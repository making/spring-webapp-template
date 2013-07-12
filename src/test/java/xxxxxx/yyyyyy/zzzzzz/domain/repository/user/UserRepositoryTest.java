package xxxxxx.yyyyyy.zzzzzz.domain.repository.user;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import xxxxxx.yyyyyy.zzzzzz.domain.model.User;
import xxxxxx.yyyyyy.zzzzzz.domain.repository.user.UserRepository;


import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class UserRepositoryTest {
    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Autowired
    protected UserRepository userRepository;

    private DateTime now = new DateTime();

    @Before
    @Rollback(value = false)
    public void setUp() throws Exception {
        jdbcTemplate.execute("DELETE FROM T_USER");

        List<Object[]> args = new ArrayList<Object[]>();
        for (int i = 0; i < 20; i++) {
            DateTime birth = new DateTime().withDate(1990 + i, i % 12 + 1,
                    i % 30 + 1);
            Object[] arg = new Object[] { "name" + i,
                    "name" + i + "@example.com", birth.toDate(),
                    "password" + i, now.toDate(), now.toDate(), 1 };
            args.add(arg);
        }
        jdbcTemplate
                .batchUpdate(
                        "INSERT INTO T_USER(USER_NAME, USER_EMAIL, USER_BIRTH, USER_PASSWORD, CREATED_AT, UPDATED_AT, VERSION) VALUES(?,?,?,?,?,?,?)",
                        args);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testFindByNameLike01() {
        Page<User> page = userRepository.findByNameLike("name1%",
                new PageRequest(1, 3));
        assertThat(page, is(notNullValue()));
        assertThat(page.getNumber(), is(1));
        assertThat(page.getNumberOfElements(), is(3));
        assertThat(page.getTotalElements(), is(11L));
        assertThat(page.getTotalPages(), is(4));
        List<User> users = page.getContent();
        assertThat(users.size(), is(3));
        // name1
        // name10
        // name11
        assertThat(users.get(0).getName(), is("name12"));
        assertThat(users.get(0).getEmail(), is("name12@example.com"));
        assertThat(users.get(1).getName(), is("name13"));
        assertThat(users.get(1).getEmail(), is("name13@example.com"));
        assertThat(users.get(2).getName(), is("name14"));
        assertThat(users.get(2).getEmail(), is("name14@example.com"));
    }

    @Test
    public void testSaveAndFlush01() {
        User user = new User();
        user.setName("foo");
        user.setEmail("foo@example.com");
        user.setBirth(new Date());
        user.setPassword("foo");
        user.setCreatedAt(now.toDate());
        user.setUpdatedAt(now.toDate());
        userRepository.saveAndFlush(user);

        Integer id = user.getId();
        assertThat(id, is(notNullValue()));

        Map<String, Object> result = jdbcTemplate.queryForMap(
                "SELECT * FROM T_USER WHERE USER_ID = ?", id);
        assertThat((Integer) result.get("USER_ID"), is(id));
        assertThat((String) result.get("USER_NAME"), is("foo"));
        assertThat((String) result.get("USER_EMAIL"), is("foo@example.com"));
        assertThat((String) result.get("USER_NAME"), is("foo"));
        assertThat((String) result.get("USER_PASSWORD"), is("foo"));
        assertThat((Date) result.get("CREATED_AT"), is(now.toDate()));
        assertThat((Date) result.get("UPDATED_AT"), is(now.toDate()));
    }

    // @Test(expected = OptimisticLockingFailureException.class) TODO
    //    @Test
    //    public void testUpdate01() {
    //        Integer id = (Integer) jdbcTemplate.queryForList(
    //                "SELECT USER_ID FROM T_USER", Integer.class).get(0);
    //        User user = userRepository.findOne(id);
    //        assertThat(user, is(notNullValue()));
    //        user.setVersion(2);
    //        userRepository.saveAndFlush(user);
    //    }
}

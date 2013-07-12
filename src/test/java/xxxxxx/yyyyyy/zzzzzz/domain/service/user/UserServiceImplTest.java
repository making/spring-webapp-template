package xxxxxx.yyyyyy.zzzzzz.domain.service.user;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;

import xxxxxx.yyyyyy.zzzzzz.domain.model.User;
import xxxxxx.yyyyyy.zzzzzz.domain.repository.user.UserRepository;
import xxxxxx.yyyyyy.zzzzzz.domain.service.user.UserServiceImpl;

public class UserServiceImplTest {
    protected UserServiceImpl userService;

    protected UserRepository userRepository;

    protected PasswordEncoder passwordEncoder;

    @Before
    public void setUp() {
        userService = new UserServiceImpl();
        userRepository = mock(UserRepository.class);
        userService.userRepository = userRepository;
        passwordEncoder = mock(PasswordEncoder.class);
        userService.passwordEncoder = passwordEncoder;
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setName("foo");

        when(passwordEncoder.encode("password")).thenReturn("xxxx");

        userService.save(user, "password");

        ArgumentCaptor<User> userArg = ArgumentCaptor.forClass(User.class);
        verify(userRepository, times(1)).save(userArg.capture());
        User actual = userArg.getValue();
        assertThat(actual, is(user));
        assertThat(user.getCreatedAt(), is(notNullValue()));
        assertThat(user.getUpdatedAt(), is(notNullValue()));
        assertThat(user.getPassword(), is("xxxx"));
    }

    @Test
    public void testFindOne() {
        User user = new User();
        when(userRepository.findOne(100)).thenReturn(user);

        User result = userService.findOne(100);

        assertThat(result, is(user));
    }

    @Test
    public void testFindAll() {
        Pageable pageable = new PageRequest(1, 10);
        Page<User> page = new PageImpl<User>(Arrays.asList(new User()));
        when(userRepository.findAll(pageable)).thenReturn(page);

        Page<User> result = userService.findAll(pageable);

        assertThat(result, is(page));
    }

    @Test
    public void testFindByNameLike() {
        Pageable pageable = new PageRequest(1, 10);
        Page<User> page = new PageImpl<User>(Arrays.asList(new User()));
        when(userRepository.findByNameLike("foo", pageable)).thenReturn(page);

        Page<User> result = userService.findByNameLike("foo", pageable);

        assertThat(result, is(page));
    }

    @Test
    public void testDelete() {
        User user = new User();

        userService.delete(user);

        ArgumentCaptor<User> userArg = ArgumentCaptor.forClass(User.class);
        verify(userRepository, times(1)).delete(userArg.capture());
        assertThat(userArg.getValue(), is(user));
    }

}

package xxxxxx.yyyyyy.zzzzzz.domain.service.user;

import java.util.Date;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xxxxxx.yyyyyy.zzzzzz.domain.model.User;
import xxxxxx.yyyyyy.zzzzzz.domain.repository.user.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected PasswordEncoder passwordEncoder;

    @Override
    public void save(User user, String rawPassword) {
        String password = passwordEncoder.encodePassword(rawPassword, user
                .getName());
        user.setPassword(password);
        Date now = new DateTime().toDate();
        if (user.getCreatedAt() == null) {
            user.setCreatedAt(now);
        }
        user.setUpdatedAt(now);
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findOne(Integer id) {
        User user = userRepository.findOne(id);
        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<User> findAll(Pageable pageable) {
        Page<User> page = userRepository.findAll(pageable);
        return page;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<User> findByNameLike(String name, Pageable pageable) {
        String query = name + "%"; // TODO escape
        Page<User> page = userRepository.findByNameLike(query, pageable);
        return page;
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

}

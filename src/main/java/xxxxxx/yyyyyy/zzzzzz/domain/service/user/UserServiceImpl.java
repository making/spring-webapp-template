package xxxxxx.yyyyyy.zzzzzz.domain.service.user;

import java.util.Date;

import javax.inject.Inject;

import org.joda.time.DateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xxxxxx.yyyyyy.zzzzzz.domain.common.exception.ResourceNotFoundException;
import xxxxxx.yyyyyy.zzzzzz.domain.model.User;
import xxxxxx.yyyyyy.zzzzzz.domain.repository.user.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Inject
    protected UserRepository userRepository;

    @Inject
    protected PasswordEncoder passwordEncoder;

    @Override
    public void save(User user, String rawPassword) {
        String password = passwordEncoder.encode(rawPassword);
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
        if (user == null) {
            throw new ResourceNotFoundException("User [id=" + id
                    + "] is not found.");
        }
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
        String query = name; // TODO escape
        Page<User> page = userRepository.findByNameLike(query, pageable);
        return page;
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

}

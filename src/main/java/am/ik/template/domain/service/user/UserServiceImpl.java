package am.ik.template.domain.service.user;

import java.util.Date;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import am.ik.template.domain.model.User;
import am.ik.template.domain.repository.user.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    protected UserRepository userRepository;

    @Override
    public void save(User user) {
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
        Page<User> page = userRepository.findByNameLike(name, pageable);
        return page;
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

}

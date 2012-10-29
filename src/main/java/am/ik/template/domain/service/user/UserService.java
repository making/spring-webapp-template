package am.ik.template.domain.service.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import am.ik.template.domain.model.User;

public interface UserService {
    void save(User user);

    User findOne(Integer id);

    Page<User> findAll(Pageable pageable);

    Page<User> findByNameLike(String name, Pageable pageable);

    void delete(User user);
}

package am.ik.template.domain.repository.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import am.ik.template.domain.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT x FROM User x WHERE x.id = :id AND x.name IS NOT NULL")
    @Override
    User findOne(@Param("id")
    Integer id);

    @Query("SELECT x FROM User x WHERE x.name LIKE :name")
    Page<User> findByNameLike(@Param("name")
    String name, Pageable page);
}

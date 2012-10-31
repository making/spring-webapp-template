package xxxx.yyyy.zzzz.app.user.facade;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xxxx.yyyy.zzzz.app.user.model.UserCreateForm;
import xxxx.yyyy.zzzz.app.user.model.UserUpdateForm;
import xxxx.yyyy.zzzz.domain.model.User;
import xxxx.yyyy.zzzz.domain.service.user.UserService;

@Service
@Transactional
public class UserFacadeImpl implements UserFacade {
    @Autowired
    protected UserService userService;

    @Autowired
    protected PasswordEncoder passwordEncoder;

    @Override
    public void create(UserCreateForm form) {
        User user = new User();
        BeanUtils.copyProperties(form, user);
        user.setPassword(passwordEncoder.encodePassword(form.getPassword(),
                form.getName()));
        userService.save(user);
    }

    @Override
    public void update(UserUpdateForm form) {
        User user = userService.findOne(form.getId());
        BeanUtils.copyProperties(form, user, new String[] { "password" });
        user.setPassword(passwordEncoder.encodePassword(form.getPassword(),
                form.getName()));
        userService.save(user);
    }
}

package xxxx.yyyy.zzzz.app.user.facade;

import xxxx.yyyy.zzzz.app.user.model.UserCreateForm;
import xxxx.yyyy.zzzz.app.user.model.UserUpdateForm;

public interface UserFacade {
    void create(UserCreateForm form);

    void update(UserUpdateForm form);
}

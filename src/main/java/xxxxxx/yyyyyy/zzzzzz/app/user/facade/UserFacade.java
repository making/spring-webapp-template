package xxxxxx.yyyyyy.zzzzzz.app.user.facade;

import xxxxxx.yyyyyy.zzzzzz.app.user.model.UserCreateForm;
import xxxxxx.yyyyyy.zzzzzz.app.user.model.UserUpdateForm;

public interface UserFacade {
    void create(UserCreateForm form);

    void update(UserUpdateForm form);
}

package am.ik.template.app.user.facade;

import am.ik.template.app.user.model.UserCreateForm;
import am.ik.template.app.user.model.UserUpdateForm;

public interface UserFacade {
    void create(UserCreateForm form);

    void update(UserUpdateForm form);
}

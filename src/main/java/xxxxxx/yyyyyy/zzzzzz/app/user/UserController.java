package xxxxxx.yyyyyy.zzzzzz.app.user;

import javax.inject.Inject;
import javax.validation.groups.Default;

import org.dozer.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import xxxxxx.yyyyyy.zzzzzz.app.user.UserForm.UserCreateGroup;
import xxxxxx.yyyyyy.zzzzzz.app.user.UserForm.UserDeleteGroup;
import xxxxxx.yyyyyy.zzzzzz.app.user.UserForm.UserUpdateGroup;
import xxxxxx.yyyyyy.zzzzzz.domain.model.User;
import xxxxxx.yyyyyy.zzzzzz.domain.service.user.UserService;

@Controller
@RequestMapping("user")
public class UserController {
    @Inject
    protected UserService userService;

    @Inject
    protected Mapper beanMapper;

    @ModelAttribute
    public UserForm setUpUserForm() {
        return new UserForm();
    }

    // create flow

    @RequestMapping(value = "create", params = "form", method = RequestMethod.GET)
    public String createForm(UserForm form) {
        return "user/createForm";
    }

    @RequestMapping(value = "create", params = "confirm", method = RequestMethod.POST)
    public String createConfirm(@Validated({ Default.class,
            UserCreateGroup.class }) UserForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "user/createForm";
        }
        return "user/createConfirm";
    }

    @RequestMapping(value = "create", params = "redo", method = RequestMethod.POST)
    public String createRedo(UserForm form) {
        // reset password
        form.setPassword("");
        form.setConfirmPassword("");
        return "user/createForm";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(
            @Validated({ Default.class, UserCreateGroup.class }) UserForm form,
            BindingResult result) {
        if (result.hasErrors()) {
            return "user/createForm";
        }

        User user = beanMapper.map(form, User.class);
        userService.save(user, form.getPassword());

        return "redirect:/user/create?complete";
    }

    @RequestMapping(value = "create", params = "complete", method = RequestMethod.GET)
    public String createComplete() {
        return "user/createComplete";
    }

    // update flow

    @RequestMapping(value = "update", params = "form", method = RequestMethod.GET)
    public String updateForm(@RequestParam("id") Integer id, UserForm form,
            Model model) {

        User user = userService.findOne(id);
        beanMapper.map(user, form, "userExcludePassword");

        model.addAttribute(user);

        return "user/updateForm";
    }

    @RequestMapping(value = "update", params = "confirm", method = RequestMethod.POST)
    public String updateConfirm(@Validated({ Default.class,
            UserUpdateGroup.class }) UserForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "user/updateForm";
        }
        return "user/updateConfirm";
    }

    @RequestMapping(value = "update", params = "redo", method = RequestMethod.POST)
    public String updateRedo(@RequestParam("id") Integer id, UserForm form,
            Model model) {

        // reset password
        form.setPassword("");
        form.setConfirmPassword("");

        return "user/updateForm";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(
            @Validated({ Default.class, UserUpdateGroup.class }) UserForm form,
            BindingResult result) {
        if (result.hasErrors()) {
            return "user/updateForm";
        }

        User user = userService.findOne(form.getId());
        beanMapper.map(form, user);
        userService.save(user, form.getPassword());

        return "redirect:/user/update?complete";
    }

    @RequestMapping(value = "update", params = "complete", method = RequestMethod.GET)
    public String updateComplete() {
        return "user/updateComplete";
    }

    // delete flow

    @RequestMapping(value = "delete", params = "form", method = RequestMethod.GET)
    public String deleteForm(@RequestParam("id") Integer id, UserForm form,
            Model model) {

        User user = userService.findOne(id);
        beanMapper.map(user, form);

        model.addAttribute(user);
        return "user/deleteForm";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String delete(
            @Validated({ Default.class, UserDeleteGroup.class }) UserForm form,
            BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            attr.addFlashAttribute("errorMessage", "Illegal Access!");
            return "redirect:/user/list";
        }

        User user = userService.findOne(form.getId());
        beanMapper.map(form, user);

        userService.delete(user);
        return "redirect:/user/delete?complete";
    }

    @RequestMapping(value = "delete", params = "complete")
    public String deleteComplete() {
        return "user/deleteComplete";
    }

    @RequestMapping(value = { "create", "update", "delete" }, params = "redirectToList")
    public String redirectToList() {
        return "redirect:/user/list";
    }
}

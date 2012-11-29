package xxxxxx.yyyyyy.zzzzzz.app.user.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import xxxxxx.yyyyyy.zzzzzz.app.user.model.UserCreateForm;
import xxxxxx.yyyyyy.zzzzzz.app.user.model.UserDeleteForm;
import xxxxxx.yyyyyy.zzzzzz.app.user.model.UserUpdateForm;
import xxxxxx.yyyyyy.zzzzzz.domain.model.User;
import xxxxxx.yyyyyy.zzzzzz.domain.service.user.UserService;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    protected UserService userService;

    @ModelAttribute
    public UserCreateForm setUpUserCreateForm() {
        return new UserCreateForm();
    }

    @ModelAttribute
    public UserUpdateForm setUpUserUpdateForm() {
        return new UserUpdateForm();
    }

    @ModelAttribute
    public UserDeleteForm setUpUserDeleteForm() {
        return new UserDeleteForm();
    }

    @RequestMapping(value = "create", params = "form")
    public String createForm(UserCreateForm form) {
        return "user/createForm";
    }

    @RequestMapping(value = "create", params = "confirm", method = RequestMethod.POST)
    public String createConfirm(@Valid UserCreateForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "user/createForm";
        }
        return "user/createConfirm";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Valid UserCreateForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "user/createForm";
        }

        User user = new User();
        BeanUtils.copyProperties(form, user);
        userService.save(user, form.getPassword());

        return "redirect:/user/create?complete";
    }

    @RequestMapping(value = "create", params = "complete")
    public String createComplete() {
        return "user/createComplete";
    }

    @RequestMapping(value = "update", params = "form")
    public String updateForm(@RequestParam("id") Integer id,
            UserUpdateForm form, Model model) {

        if (form.getVersion() == null) {
            User user = userService.findOne(id);
            BeanUtils.copyProperties(user, form, new String[] { "password" });
            model.addAttribute(user);
        }

        return "user/updateForm";
    }

    @RequestMapping(value = "update", params = "confirm", method = RequestMethod.POST)
    public String updateConfirm(@Valid UserUpdateForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "user/updateForm";
        }
        return "user/updateConfirm";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid UserUpdateForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "user/updateForm";
        }

        User user = userService.findOne(form.getId());
        BeanUtils.copyProperties(form, user);
        userService.save(user, form.getPassword());

        return "redirect:/user/update?complete";
    }

    @RequestMapping(value = "update", params = "complete")
    public String updateComplete() {
        return "user/updateComplete";
    }

    @RequestMapping(value = "delete", params = "confirm")
    public String deleteConfirm(@RequestParam("id") Integer id,
            UserDeleteForm form, Model model) {

        User user = userService.findOne(id);
        BeanUtils.copyProperties(user, form);

        model.addAttribute(user);
        return "user/deleteConfirm";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String delete(@Valid UserDeleteForm form, BindingResult result,
            RedirectAttributes attr) {
        if (result.hasErrors()) {
            attr.addFlashAttribute("errorMessage", "Illegal Access!");
            return "redirect:/user/list";
        }

        User user = userService.findOne(form.getId());
        BeanUtils.copyProperties(form, user);

        userService.delete(user);
        return "redirect:/user/delete?complete";
    }

    @RequestMapping(value = "delete", params = "complete")
    public String deleteComplete() {
        return "user/deleteComplete";
    }

    @RequestMapping(value = { "cretate", "update", "delete" }, params = "redirectToList")
    public String redirectToList() {
        return "redirect:/user/list";
    }
}

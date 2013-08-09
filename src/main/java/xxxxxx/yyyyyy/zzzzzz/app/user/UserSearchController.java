package xxxxxx.yyyyyy.zzzzzz.app.user;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import xxxxxx.yyyyyy.zzzzzz.domain.model.User;
import xxxxxx.yyyyyy.zzzzzz.domain.service.user.UserService;

@Controller
@RequestMapping("user")
public class UserSearchController {
    @Inject
    protected UserService userService;

    @ModelAttribute
    public UserSearchForm setUpForm() {
        return new UserSearchForm();
    }

    @RequestMapping("list")
    public String list(@PageableDefaults Pageable pageable, Model model) {
        Page<User> page = userService.findAll(pageable);
        model.addAttribute("page", page);
        return "user/list";
    }

    @RequestMapping("search")
    public String search(@Valid UserSearchForm form, BindingResult result,
            @PageableDefaults Pageable pageable, Model model) {
        if (result.hasErrors()) {
            return "user/list";
        }

        String name = form.getName();
        String query = (StringUtils.hasText(name) ? name : "") + "%";
        Page<User> page = userService.findByNameLike(query, pageable);
        model.addAttribute("page", page);
        return "user/list";
    }

    @RequestMapping(params = "redirectToUpdate")
    public String redirectToUpdateForm(@RequestParam("id") Integer id,
            RedirectAttributes attr) {
        attr.addAttribute("id", id);
        return "redirect:/user/update?form";
    }

    @RequestMapping(params = "redirectToDelete")
    public String redirectToDeleteForm(@RequestParam("id") Integer id,
            RedirectAttributes attr) {
        attr.addAttribute("id", id);
        return "redirect:/user/delete?form";
    }
}

package com.dsi.spring.controllers;

import com.dsi.spring.model.Account;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class AccountController {
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor ste = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, ste);
    }

    @RequestMapping("/")
    public String showHomePage() {
        return "index";
    }

    @RequestMapping("/new")
    public String newAccount(Model model) {
        model.addAttribute("account", new Account());
        return "newAccount";
    }

    @RequestMapping("/showAccount")
    public String showAccount() {
        return "showAccount";
    }

    @RequestMapping(value = "/saveAccount", method = RequestMethod.POST)
    public String saveAccount(@Valid @ModelAttribute("account") Account account, BindingResult result) {
        if(result.hasErrors()) {
            return "newAccount";
        }
        return "showAccount";
    }
}

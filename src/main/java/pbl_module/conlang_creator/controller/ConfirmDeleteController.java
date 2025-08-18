package pbl_module.conlang_creator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConfirmDeleteController {

    @GetMapping("/confirm-delete")
    public String confirmDelete(@RequestParam String title,
                                @RequestParam String message,
                                @RequestParam String postUrl,
                                @RequestParam String cancelUrl,
                                @RequestParam(required = false) String confirmLabel,
                                Model model) {
        model.addAttribute("title", title);
        model.addAttribute("message", message);
        model.addAttribute("postUrl", postUrl);
        model.addAttribute("cancelUrl", cancelUrl);
        model.addAttribute("confirmLabel", confirmLabel);
        return "confirm_delete";
    }
}

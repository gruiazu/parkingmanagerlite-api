package com.hormigo.david.parkingmanager.draw.adapter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hormigo.david.parkingmanager.draw.domain.DrawDao;
import com.hormigo.david.parkingmanager.draw.service.DrawService;

@Controller
public class DrawController {

    private final DrawService drawService;
    public DrawController(DrawService drawService) {
        this.drawService = drawService;
    }
    @GetMapping("/draws")
    public String showAllDraws(Model model) {
        model.addAttribute("draws", this.drawService.getAll());
        return "draw/list";
    }

    @GetMapping("/newDraw")
    public String showDrawCreateForm(Model model) {
        DrawDao drawDao = new DrawDao();
        model.addAttribute("drawDao", drawDao);
        return "draw/createform";
    }

    @PostMapping("/newDraw")
    public String createDraw(@ModelAttribute DrawDao drawDao) {
        this.drawService.register(drawDao);
        return "redirect:/draws";
    }
}

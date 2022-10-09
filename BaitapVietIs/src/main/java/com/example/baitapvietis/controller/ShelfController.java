package com.example.baitapvietis.controller;

import com.example.baitapvietis.model.dto.ShelfDto;
import com.example.baitapvietis.model.entity.ShelfEntity;
import com.example.baitapvietis.model.entity.WareHouseEntity;
import com.example.baitapvietis.repository.ShelfRepository;
import com.example.baitapvietis.repository.WareHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class ShelfController {
    @Autowired
    private ShelfRepository shelfRepository;

    @Autowired
    private WareHouseRepository wareHouseRepository;

    @GetMapping("/shelf")
    public String  admin(Model model) {
        model.addAttribute("listShelf", shelfRepository.findAll());
        model.addAttribute("shelf", new ShelfEntity());
        model.addAttribute("listWareHouse", wareHouseRepository.findAll());
        return "shelf";
    }
    @PostMapping("/addshelf")
    public String add(Model model, @ModelAttribute("shelf") ShelfEntity shelf){
        shelfRepository.save(shelf);
        return "redirect:/shelf";
    }
    @PostMapping("/updateshelf/{id}")
    public String update(@ModelAttribute("shelfUpdate") ShelfEntity shelfUpdate, @PathVariable("id") Long id ){
        ShelfEntity shelf = shelfRepository.findById(id).get();
        shelf.setName(shelfUpdate.getName());
        shelf.setWareHouseName(shelfUpdate.getWareHouseName());
        shelf.setNumberOfStage(shelfUpdate.getNumberOfStage());


        shelfRepository.save(shelf);
        return "redirect:/shelf";
    }
    @RequestMapping(value = "/deleteshelf/{id}",method = RequestMethod.POST)
    public String delete(Principal principal, @PathVariable("id") Long id ){
        ShelfEntity shelf = shelfRepository.findById(id).get();
        shelfRepository.delete(shelf);
        return "redirect:/shelf";
    }

}

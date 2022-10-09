package com.example.baitapvietis.controller;

import com.example.baitapvietis.model.entity.ReaderEntity;
import com.example.baitapvietis.repository.ReaderRepository;
import com.example.baitapvietis.repository.WareHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReaderController {
    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private WareHouseRepository wareHouseRepository;

    @GetMapping("/reader")
    public String  admin(Model model) {
        model.addAttribute("listReader", readerRepository.findAll());
        model.addAttribute("reader", new ReaderEntity());
        model.addAttribute("listWareHouse", wareHouseRepository.findAll());
        return "Reader";
    }
    @PostMapping("/addreader")
    public String add(Model model, @ModelAttribute("reader") ReaderEntity reader){
        readerRepository.save(reader);
        return "redirect:/reader";
    }
//    @PostMapping("/updateshelf/{id}")
//    public String update(@ModelAttribute("shelfUpdate") ShelfEntity shelfUpdate, @PathVariable("id") Long id ){
//        ShelfEntity shelf = shelfRepository.findById(id).get();
//        shelf.setName(shelfUpdate.getName());
//        shelf.setWareHouseName(shelfUpdate.getWareHouseName());
//        shelf.setNumberOfStage(shelfUpdate.getNumberOfStage());
//
//
//        shelfRepository.save(shelf);
//        return "redirect:/shelf";
//    }
//    @RequestMapping(value = "/deleteshelf/{id}",method = RequestMethod.POST)
//    public String delete(Principal principal, @PathVariable("id") Long id ){
//        ShelfEntity shelf = shelfRepository.findById(id).get();
//        shelfRepository.delete(shelf);
//        return "redirect:/shelf";
//    }
}

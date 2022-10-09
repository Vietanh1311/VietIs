package com.example.baitapvietis.controller;

import com.example.baitapvietis.model.entity.ClassificationEntity;
import com.example.baitapvietis.model.entity.WareHouseEntity;
import com.example.baitapvietis.repository.ClassfisicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class ClassfisicationController {
    @Autowired
    private ClassfisicationRepository classfisicationRepository;

    @GetMapping("/classfisication")
    public String  admin(Model model) {
        model.addAttribute("listClassfisication", classfisicationRepository.findAll());
        model.addAttribute("classfisication", new ClassificationEntity());
        return "classfisication";
    }
    @PostMapping("/addclassfisication")
    public String add(Model model, @ModelAttribute("classfisication")ClassificationEntity classfisication){
        classfisicationRepository.save(classfisication);
        return "redirect:/classfisication";
    }
    @PostMapping("/updateclassfisication/{id}")
    public String update(@ModelAttribute("classfisicationUpdate") ClassificationEntity classfisicationUpdate, @PathVariable("id") Long id ){
        ClassificationEntity classfisication = classfisicationRepository.findById(id).get();
        classfisication.setName(classfisicationUpdate.getName());
        classfisicationRepository.save(classfisication);
        return "redirect:/classfisication";
    }
    @RequestMapping(value = "/deleteclassfisication/{id}",method = RequestMethod.POST)
    public String delete(Principal principal, @PathVariable("id") Long id ){
        ClassificationEntity classfisication = classfisicationRepository.findById(id).get();
        classfisicationRepository.delete(classfisication);
        return "redirect:/classfisication";
    }

}

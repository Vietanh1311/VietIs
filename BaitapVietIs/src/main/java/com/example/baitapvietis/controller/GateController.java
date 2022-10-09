package com.example.baitapvietis.controller;

import com.example.baitapvietis.model.entity.GateEntity;
import com.example.baitapvietis.model.entity.ShelfEntity;
import com.example.baitapvietis.repository.GateRepository;
import com.example.baitapvietis.repository.WareHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class GateController {
    @Autowired
    private GateRepository gateRepository;

    @Autowired
    private WareHouseRepository wareHouseRepository;

    @GetMapping("/gate")
    public String  admin(Model model) {
        model.addAttribute("listGate", gateRepository.findAll());
        model.addAttribute("gate", new GateEntity());
        model.addAttribute("listWareHouse", wareHouseRepository.findAll());
        return "gate";
    }
    @PostMapping("/addgate")
    public String add(Model model, @ModelAttribute("gate") GateEntity gate){
        gateRepository.save(gate);
        return "redirect:/gate";
    }
    @PostMapping("/updategate/{id}")
    public String update(@ModelAttribute("gateUpdate") GateEntity gateUpdate, @PathVariable("id") Long id ){
        GateEntity gate = gateRepository.findById(id).get();
        gate.setName(gateUpdate.getName());
        gate.setWareHouseName(gateUpdate.getWareHouseName());
        gate.setIpadress(gateUpdate.getIpadress());

        gateRepository.save(gate);
        return "redirect:/gate";
    }
    @RequestMapping(value = "/deletegate/{id}",method = RequestMethod.POST)
    public String delete(Principal principal, @PathVariable("id") Long id ){
        GateEntity gate= gateRepository.findById(id).get();
        gateRepository.delete(gate);
        return "redirect:/gate";
    }
}

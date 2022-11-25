package cz.czechitas.java2webapps.ukol6.controller;

import cz.czechitas.java2webapps.ukol6.entity.Vizitka;
import cz.czechitas.java2webapps.ukol6.repository.VizitkaRepository;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class VizitkaController {

    private final VizitkaRepository vizitkaRepository;

    public VizitkaController(VizitkaRepository vizitkaRepository) {
        this.vizitkaRepository=vizitkaRepository;
    }

    @InitBinder
    public void nullStringBinding(WebDataBinder binder) {
        //prázdné textové řetězce nahradit null hodnotou
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping("/")
    public Object seznam() {
        return new ModelAndView("seznam")
                .addObject("seznam", vizitkaRepository.findAll());
    }

    @GetMapping("/{id:[0-9]+}")
    public Object detail(@PathVariable long id) {
        Optional<Vizitka> vizitka = vizitkaRepository.findById(id);
        if (vizitka.isEmpty()) {
            return ResponseEntity.notFound().build();
         //   throw  new ResponseStatusException((HttpStatus.NOT_FOUND));
        }
        return new ModelAndView("vizitka")
                .addObject("vizitka",vizitka.get());
    }

    @GetMapping("/nova")
    public Object nova() {
        return new ModelAndView("formular")
                .addObject("vizitka", new Vizitka());
    }

    @PostMapping("/nova")
    public Object pridat(@ModelAttribute("vizitka") @Valid Vizitka vizitka, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formular";
        }
        vizitka.setId(null);
        vizitkaRepository.save(vizitka);
        return "redirect:/";
    }
}

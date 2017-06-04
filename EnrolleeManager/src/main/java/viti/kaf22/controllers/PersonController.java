//package viti.kaf22.controllers;
//
//import org.apache.log4j.Logger;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//import viti.kaf22.entities.Abiturient;
//import viti.kaf22.entities.NomerTelefonu;
//import viti.kaf22.entities.Person;
//
//import java.util.HashSet;
//
///**
// * Created by korch on 30.05.17
// */
//@Controller
//public class PersonController {
//
//    public static final Logger log = Logger.getLogger(PersonController.class);
//    public Abiturient person;
//
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String create(@ModelAttribute("person")Abiturient person){
//        return "redirect:/index";
//    }
//
//    @RequestMapping(value = "index", method = {RequestMethod.POST, RequestMethod.GET})
//    public ModelAndView index(@ModelAttribute("person") Abiturient person, ModelAndView modelAndView){
////        modelAndView.setViewName("persIndex");
////        person.setNomerTelefonus(new HashSet<NomerTelefonu>());
////        person.getNomerTelefonus().add(new NomerTelefonu());
////        modelAndView.addObject("person", person);
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "add", method = RequestMethod.POST)
//    public String addPerson(@ModelAttribute("person") Abiturient person){
//        log.trace(person.getSprava());
//        return "redirect:/";
//    }
//}

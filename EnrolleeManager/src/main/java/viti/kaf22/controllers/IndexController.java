package viti.kaf22.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import viti.kaf22.entities.*;
import viti.kaf22.entities.decorator.AbiturientCase;
import viti.kaf22.services.AbiturientService;
import viti.kaf22.services.HService;

import java.util.Collection;

/**
 * Created by korch on 27.05.17
 */
@Controller
public class IndexController {
    private static final Logger log =  Logger.getLogger(IndexController.class);

    @Autowired
    public AbiturientService abiturientService;

    @Autowired
    public HService hService;

    private Abiturient abiturient;
    private AbiturientCase abiturientCase;

    @ModelAttribute("abiturients")
    public Collection<Abiturient> getAllAbiturient(){
        log.trace("get all abiturient---------------------");
        return abiturientService.getAllWithLazy();
    }

    @ModelAttribute("zvannya")
    public Collection<Zvanya> getAllRank(){
        return hService.getAll(Zvanya.class);
    }

    @ModelAttribute("statuses")
    public Collection<SocialniyStatus> getAllStatus(){
        return hService.getAll(SocialniyStatus.class);
    }

    @ModelAttribute("stati")
    public Collection<Stat> getAllStat(){return  hService.getAll(Stat.class);}

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelAndView modelAndView){
        abiturientCase = new AbiturientCase(new Abiturient());
        log.trace("Success created new abiturientCase");
        return "redirect:/vstup";
    }

    @RequestMapping(value = "/vstup", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView showStartPage(@ModelAttribute("abiturient") AbiturientCase abiturientCase,
                                      ModelAndView modelAndView) {
        log.info("\n=====================================================================================================");
        modelAndView.addObject("abiturients", getAllAbiturient());
        modelAndView.addObject("abiturient", abiturientCase);
        modelAndView.setViewName("index");
        log.info("Success loaded home page");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.GET})
    public String addAbitur(@ModelAttribute("abiturient") AbiturientCase abiturientCase,
                            ModelAndView modelAndView){
        log.trace("Starting insert new abiturientCase " + abiturientCase.getAbiturient());
        Abiturient abiturient = abiturientCase.getAbiturient();

        abiturientService.saveOrUpdate(abiturient);
        log.info("Success added abiturient: " + abiturient);
        return "redirect:/";
    }


    @RequestMapping(value = "/update2", method = {RequestMethod.POST, RequestMethod.GET})
    public String update2(@ModelAttribute("abiturient") Abiturient abiturient,
                            ModelAndView modelAndView){
        log.trace("Starting update new abiturientCase " + abiturient.getImya().getName());

        return "redirect:/";
    }

    public void hello(){
        System.out.println("hello word");
    }
}

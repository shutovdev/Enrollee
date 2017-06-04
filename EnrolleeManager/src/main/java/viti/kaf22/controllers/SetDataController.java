//package viti.kaf22.controllers;
//
//
//import viti.kaf22.services.AbiturientService;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//import viti.kaf22.entities.*;
//
//
///**
// * Created by korch on 07.04.17
// */
//@Controller
////@SessionAttributes(value = {"abiturients", "stati", "socStatuses"/*, "abiturient"*/})
//public class SetDataController {
//    public static final Logger log = Logger.getLogger(SetDataController.class);
//
//    @Autowired
//    private AbiturientService abiturientService;
//
//    //    @Autowired
////    private AbiturientService abiturientService;
////    @Autowired
////    private SocStatusService socStatusService;
////    @Autowired
////    private ImyaService imyaService;
////    @Autowired
////    private StatService statService;
////    @Autowired
////    private NomerTelService nomerTelService;
////    @Autowired
////    private DisciplineZnoService znoService;
//
//    private Abiturient abiturient;
//
//    private AbiturientCase abiturientCase;
//
//
////
////    @ModelAttribute("abiturients")
////    public Collection<Abiturient> getAbiturients() {
////        log.debug("Select all baseAbiturients");
////        XLSController<Abiturient> xlsController = new XLSController<Abiturient>("primary");
//////        xlsController.saveAllToSheet(abiturientService.getAllAbiturient());
////        return abiturientService.getAll();
////    }
////
////    @ModelAttribute("socStatuses")
////    public Collection<SocialniyStatus> getSocStatus() {
////        log.debug("Select all socStatuses");
////        return socStatusService.getAllSocStatus();
////    }
////
////    @ModelAttribute("stati")
////    public Collection<Stat> getStati() {
////        log.debug("Select all stati");
////        return statService.getAllStat();
////    }
//////    @ModelAttribute("disciplines")
//////    public List<DisciplineZno> getDicipline(){
//////        log.debug("Select all discipline");
////////        return (List<DisciplineZno>) znoService.getAllDisciplineZno();
//////    }
////
////
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String createBaseAbiturient(ModelAndView model){
//        abiturient = new Abiturient();
//        //        this.abiturientCase = new AbiturientCase(new Abiturient());
//        return "redirect:/vstup";
//    }
//
//    @RequestMapping(value = "/vstup", method = {RequestMethod.POST, RequestMethod.GET})
//    public ModelAndView showStartPage(@ModelAttribute("abiturient") Abiturient abiturient,
//                       @ModelAttribute("discipline") DisciplineZno discipline, ModelAndView modelAndView, Model model) {
//        log.trace("\n==================================================================================================");
//        log.trace("showStartPage");
////        if (this.abiturient != null)
//////        log.fatal(this.abiturientCase.getAbiturient()+"////////////////////");
////        if (abiturient != null && this.abiturient != null){
//////            log.fatal(abiturient.getAbiturient()+"++++++++++++");
////            abiturient.setAbiturient(this.abiturientCase.getAbiturient());
////            if (abiturient.getAbiturient() == null) {
////                abiturient.setAbiturient(new Abiturient());
////                log.fatal("success created new abiturient!");
////            }
////        }
////        discipline = znoService.getDisciplineZno(1);
////        InfoDataCase infoDataCase = new InfoDataCase();
////        infoDataCase.setDiscipline(discipline);
//
//
////        model.addAttribute("infoDateCase", infoDataCase);
//        model.addAttribute("abiturient", abiturient);
////        log.fatal(model.asMap().values().toArray());
//        modelAndView.setViewName("index");
//        log.info("Success loaded home page");
//        return modelAndView;
//    }
////
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public String addAbiturient(@ModelAttribute("abiturient") Abiturient abiturient,
//                                             ModelAndView modelAndView){
//        log.trace("Starting insert new abiturient");
////        log.trace("+++++++++++++++++++++++"+ abiturientCase.getAbiturient().getStatus().getName());
////        log.trace("Nomer TELEFONU" + abiturientCase.getAbiturient().getNomerTelefonus().size());
//
////        for (NomerTelefonu str : abiturientCase.getAbiturient().getNomerTelefonus())
////        log.trace("Nomer TELEFONU" + str.getNomer());
//
//        try {
////            abiturientService.setAbiturient(abiturientCase.getAbiturient());
////            log.info("Success insert new abiturient with personal id = " + abiturientCase.getOsobovaSpravaId());
//        } catch (Exception e) {
//            modelAndView.addObject("messege", "Вже існує абітурієнт з таким номером особової справи");
//            log.error("Exception added abiturient");
//            log.error(e.getMessage());
//        }
//        return "redirect:/";
//    }
////
////    @RequestMapping(value = "/delete", method = RequestMethod.POST)
////    public String delete(@RequestBody String abiturientID) {
////        log.trace("Starting delete abiturient");
////        AbiturientCase abiturientCase = new AbiturientCase(new Abiturient());
////        abiturientCase.setAbiturient(abiturientService.getAbiturient(Integer.parseInt(abiturientID)));
////        abiturientService.deleteAbiturient(abiturientCase.getAbiturient());
////        log.info("Success deleted abiturient");
////        return "redirect:/";
////    }
////
////    @RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.GET})
////    public String update(@RequestBody String abiturientID/*, @ModelAttribute("abiturient") AbiturientCase abiturient*/,
////                         Model model, ModelAndView modelAndView) {
////        log.trace(abiturientID+"update");
////        AbiturientCase abiturientCase = new AbiturientCase(new Abiturient());
////        abiturientCase.setAbiturient(abiturientService.getAbiturient(Integer.parseInt(abiturientID)));
////        log.fatal(abiturientCase.getAbiturient().getImya().getName());
////        modelAndView.setViewName("main");
////        model.addAttribute("messege", "hello kafedra 22");
////        model.addAttribute("abiturient", abiturientCase);
////        log.debug("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+ abiturientCase.getNomerTelefonu());
////        this.abiturientCase = abiturientCase;
////        log.trace(abiturientCase.getAbiturient()+" UPDATE");
////        return "redirect:/vstup";
////    }
////
////    @RequestMapping(value = "/update2", method = RequestMethod.POST)
////    public String update2(@ModelAttribute("abiturient") AbiturientCase abiturientCase, ModelAndView modelAndView) {
////        log.trace(abiturientCase +"update2");
////        log.trace(abiturientCase.getAbiturient().getImya().getName());
////        log.trace(abiturientCase.getAbiturient().getPrizvishche().getName());
////        abiturientService.updateAbiturient(abiturientCase.getAbiturient());
////        log.trace(abiturientCase.getAbiturient().getSprava());
////        return "redirect:/";
////    }
//
//
//}

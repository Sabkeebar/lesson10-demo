package edu.miu.cs.cs425.fairfieldlibraryapp.controller;

import edu.miu.cs.cs425.fairfieldlibraryapp.service.PublisherService;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/fairfieldlibrary/sysadmin/publisher")
public class PublisherController {
    private PublisherService publisherService;

//    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("/list") // /fairfieldlibrary/sysadmin/publisher/list
    public ModelAndView listPublishers(@RequestParam(defaultValue = "0") int pageNo) {
        var modelAndView = new ModelAndView();
        var publishers = publisherService.getPublishersPaged(pageNo);
        modelAndView.addObject("publishers", publishers);
        modelAndView.addObject("currentPageNo", pageNo);
        modelAndView.setViewName("secured/sysadmin/publisher/list");
        return modelAndView;
    }

    // @GetMapping("/list") // /fairfieldlibrary/sysadmin/publisher/list
    // public ModelAndView listPublishers() {
    //     var modelAndView = new ModelAndView();
    //     var publishers = publisherService.getPublishers();
    //     modelAndView.addObject("publishers", publishers);
    //     modelAndView.setViewName("secured/sysadmin/publisher/list");
    //     return modelAndView;
    // }

//    public String listPublishers2(Model model) {
//        model.addAttribute("publishers", "Publishers");
//        return "secured/sysadmin/publisher/list";
//    }

    @GetMapping(value = {"/search"})
    public ModelAndView searchPublishers(@RequestParam String searchString) {
        var modelAndView = new ModelAndView();
        var publishers = publisherService.searchPublishers(searchString);
        modelAndView.addObject("publishers", publishers);
        modelAndView.addObject("searchString", searchString);
        modelAndView.setViewName("secured/sysadmin/publisher/searchResult");
        return modelAndView;
    }

}

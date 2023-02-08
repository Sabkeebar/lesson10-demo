package edu.miu.cs.cs425.fairfieldlibrarywebapp.controller;

import edu.miu.cs.cs425.fairfieldlibrarywebapp.model.PrimaryAddress;
import edu.miu.cs.cs425.fairfieldlibrarywebapp.model.Publisher;
import edu.miu.cs.cs425.fairfieldlibrarywebapp.service.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = {"/publisher", "/fairfieldlibrary/publisher"})
public class PublisherController {

    private PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping(value = {"/list"})
    public ModelAndView listPublishers(@RequestParam(defaultValue = "0") int pageNo) {
        var modelAndView = new ModelAndView();
        var publishers = publisherService.getAllPublishersPaged(pageNo);
        modelAndView.addObject("publishers", publishers);
        modelAndView.addObject("currentPageNo", pageNo);
//        modelAndView.addObject("publishersCount", ((List)publishers).size());
        modelAndView.setViewName("secured/publisher/list");
        return modelAndView;
    }
//    @GetMapping(value = {"/list"})
//    public ModelAndView listPublishers() {
//        var modelAndView = new ModelAndView();
//        var publishers = publisherService.getAllPublishers();
//        modelAndView.addObject("publishers", publishers);
//        modelAndView.addObject("publishersCount", ((List)publishers).size());
//        modelAndView.setViewName("secured/publisher/list");
//        return modelAndView;
//    }

    @GetMapping(value = {"/new"})
    public String displayNewPublisherForm(Model model) {
        model.addAttribute("publisher", new Publisher(null, null, new PrimaryAddress()));
        return "secured/publisher/new";
    }

    @PostMapping(value = {"/new"})
    public String registerNewPublisher(@Valid @ModelAttribute("publisher") Publisher publisher,
                       BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("publisher", publisher);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/publisher/new";
        }
        if(publisher.getPrimaryAddress() != null) {
            var primaryAddr = publisher.getPrimaryAddress();
            if(primaryAddr.getStreet().equals("")
                && primaryAddr.getCity().equals("")
                && primaryAddr.getState().equals("")
                && primaryAddr.getZipCode().equals("")
            ) {
                publisher.setPrimaryAddress(null);
            }
        }
        publisherService.savePublisher(publisher);
        return "redirect:/fairfieldlibrary/publisher/list";
    }

    @GetMapping(value = {"/edit/{publisherId}"})
    public String editPublisher(@PathVariable Integer publisherId, Model model) {
        var publisher = publisherService.getPublisherById(publisherId);
        if(publisher != null) {
            model.addAttribute("publisher", publisher);
            return "secured/publisher/edit";
        }
        return "redirect:/fairfieldlibrary/publisher/list";
    }

    @PostMapping(value = {"/update"})
    public String updatePublisher(@Valid @ModelAttribute("publisher") Publisher publisher,
                               BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("publisher", publisher);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/publisher/edit";
        }
        publisherService.updatePublisher(publisher);
        return "redirect:/fairfieldlibrary/publisher/list";
    }

    @GetMapping(value = {"/delete/{publisherId}"})
    public String deletePublisher(@PathVariable Integer publisherId) {
        publisherService.deletePublisherById(publisherId);
        return "redirect:/fairfieldlibrary/publisher/list";
    }

    @GetMapping(value = {"/primaryAddress/delete/{publisherId}"})
    public String deletePrimaryAddressOfPublisher(@PathVariable Integer publisherId) {
        publisherService.deletePrimaryAddressOfPublisher(publisherId);
        return "redirect:/fairfieldlibrary/publisher/list";
    }
}

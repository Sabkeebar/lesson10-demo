package edu.miu.cs.cs425.fairfieldlibrarywebapp.controller;

import edu.miu.cs.cs425.fairfieldlibrarywebapp.service.BookService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = {"/book", "/fairfieldlibrary/book"})
public class BookController {
    private BookService bookService;

    public BookController(@Qualifier("bookServiceImpl")BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = {"/list"})
    public ModelAndView listBooks() {
        var modelAndView = new ModelAndView();
        var books = (List)bookService.getAllBooks();
        modelAndView.addObject("books", books);
        modelAndView.setViewName("secured/book/list");
        return modelAndView;
    }
}

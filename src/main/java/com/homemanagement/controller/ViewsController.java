package com.homemanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/views/*")
public class ViewsController {

    @RequestMapping(value = "html", method = RequestMethod.GET)
    public String prepare(Model model) {
        System.out.println("asdadsa");
        model.addAttribute("foo", "bar");
        model.addAttribute("fruit", "apple");
        return "views/html";
    }

    @RequestMapping(value = "/viewName", method = RequestMethod.GET)
    public void usingRequestToViewNameTranslator(Model model) {
        model.addAttribute("foo", "bar");
        model.addAttribute("fruit", "apple");
    }

    @RequestMapping(value = "pathVariables/{foo}/{fruit}", method = RequestMethod.GET)
    public String pathVars(@PathVariable String foo, @PathVariable String fruit) {
		// No need to add @PathVariables "foo" and "fruit" to the model
        // They will be merged in the model before rendering
        return "views/html";
    }

}

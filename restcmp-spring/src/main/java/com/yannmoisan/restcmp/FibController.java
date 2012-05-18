package com.yannmoisan.restcmp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yannmoisan.restcmp.service.FibService;

@Controller
@RequestMapping("/fib")
public class FibController {

    @Autowired
    private FibService service;
    
    @RequestMapping(value = "/{n}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Fib getFib(@PathVariable String n) {
        return new Fib(service.calculate(Integer.valueOf(n)));
    }

}
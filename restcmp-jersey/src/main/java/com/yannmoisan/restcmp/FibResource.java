package com.yannmoisan.restcmp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yannmoisan.restcmp.service.FibService;

@Component
@Path("/fib/{n}")
public class FibResource {

    @Autowired
    private FibService service;
    
    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Fib getFib(@PathParam("n") String n) {
        return new Fib(service.calculate(Integer.valueOf(n)));
    }
}

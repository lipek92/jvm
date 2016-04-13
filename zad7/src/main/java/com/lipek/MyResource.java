package com.lipek;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("time/{time:[0-9]*}")
public class MyResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt(@PathParam("time") String time) throws InterruptedException {
    	int response = MyClass.doSomething(time);
        return "ReqTime: "+response;
    }
}

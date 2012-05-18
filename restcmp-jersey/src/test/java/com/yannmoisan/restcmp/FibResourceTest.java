package com.yannmoisan.restcmp;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.context.ContextLoaderListener;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.spi.spring.container.servlet.SpringServlet;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;

public class FibResourceTest extends JerseyTest {

    public FibResourceTest() throws Exception {
        super(new WebAppDescriptor.Builder("com.sun.jersey.samples.springannotations.resources.jerseymanaged")
                .contextPath("restcmp")
                .contextParam("contextConfigLocation", "classpath:mvc-dispatcher-servlet.xml")
                .servletClass(SpringServlet.class)
                .initParam("com.sun.jersey.api.json.POJOMappingFeature", "true")
                .contextListenerClass(ContextLoaderListener.class).build());
    }

    @Test
    public void testGetFib() {
        WebResource webResource = resource();
        String responseMsg = webResource.path("fib/10").get(String.class);
        Assert.assertEquals("{\"fib\":[1,1,2,3,5,8,13,21,34,55]}", responseMsg);
    }
}

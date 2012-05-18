package com.yannmoisan.restcmp;

import static org.springframework.test.web.server.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.server.setup.MockMvcBuilders.*;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.springframework.test.web.server.MockMvc;

public class FibControllerTest {

    @Test
    public void testGetFib() throws Exception {
        String contextLoc = "classpath:mvc-dispatcher-servlet.xml";
        String warDir = "src/main/webapp";

        MockMvc mockMvc = xmlConfigSetup(contextLoc).configureWebAppRootDir(warDir, false).build();

        mockMvc.perform(get("/fib/10")).andExpect(content().string("{\"fib\":[1,1,2,3,5,8,13,21,34,55]}"));
    }
}
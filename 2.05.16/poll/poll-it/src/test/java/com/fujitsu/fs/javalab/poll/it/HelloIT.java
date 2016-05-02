package com.fujitsu.fs.javalab.poll.it;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.*;

public class HelloIT {

    @Test
    public void testWebApp() throws Exception {
        WebClient webClient = new WebClient();

        Properties props = new Properties();
        props.load(getClass().getResourceAsStream("/test.properties"));
        String baseUrl = props.getProperty("webapp.baseUrl");

        HtmlPage pollIndex = webClient.getPage(baseUrl);
        assertEquals("Опросы", pollIndex.getTitleText());

        webClient.close();
    }

}

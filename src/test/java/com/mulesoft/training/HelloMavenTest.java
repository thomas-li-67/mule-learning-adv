package com.mulesoft.training;

import static org.junit.Assert.*;
import org.mule.api.MuleEvent;

import org.junit.Test;
import org.mule.tck.junit4.FunctionalTestCase;

public class HelloMavenTest extends FunctionalTestCase {

    @Test
    public void mavenFlowReturnsHelloMaven() throws Exception {
        runFlowAndExpect("maventestFlow", "Hello Maven");
    } 
    
    @Test
    public void retrievelflightsAddsAppropriateHeader() throws Exception {
    	MuleEvent event = runFlow("retrieveFlights");
    	String contentType = event.getMessage().getOutboundProperty("Content-Type");
    	assertEquals("application/json", contentType);
    }
    
    @Override
    protected String getConfigFile() {
        return "maventest.xml";
    }

}

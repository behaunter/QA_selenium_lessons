package com.saucedemo.automation;

import fw.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Base {

    Logger logger = LoggerFactory.getLogger(Base.class);

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void setUp() {
        app.init();
        logger.debug("begin");
    }


    @AfterClass
    public void tearDown() {
        app.stop();
    }


}

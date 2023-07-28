package com.solvd.laba.qa.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * This is Hello World carina-demo tests.
 *
 * @author qpsdemo
 */
public class HelloWorld implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "cezeokeke")
    public void helloWorld() {
        LOGGER.info("Hello World!");
    }

}

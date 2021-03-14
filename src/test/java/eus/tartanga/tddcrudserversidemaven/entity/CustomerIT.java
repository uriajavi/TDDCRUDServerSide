/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eus.tartanga.tddcrudserversidemaven.entity;

import java.io.Serializable;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.runner.RunWith;

/**
 * Test class for Customer entity.
 * @author javi
 */
@RunWith(Arquillian.class)
public class CustomerIT {
    /**
     * Deployment archive definition for tests.
     * @return An Assignable archive base.
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class,"test.war")
                .addClass(Customer.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
                //.addAsResource("META-INF/persistence.xml");
    }

    @Inject
    Customer customer;
    
    @Test
    public void testCustomerConstruction() throws Exception {
        Customer customer=Customer.class.getConstructor().newInstance();
        assertNotNull("The bean cannot be constructed!!!",
                      customer);
    }

    @Test
    public void testCustomerInjection() throws Exception {
        assertNotNull("The bean cannot be injected!!!",
                      customer);
    }
    
    @Test
    public void testBeanIsSerializable() {
        assertTrue("The bean is not Serializable!!!",
                    customer instanceof Serializable);
    }
    
}

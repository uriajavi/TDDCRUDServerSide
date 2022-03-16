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
    
    @Test
    public void testIdProperty() {
        Long id=999999l;
        customer.setId(id);
        assertEquals("Id property is not accesible!!!",
                     id,customer.getId());
    }
    @Test
    public void testFirstNameProperty() {
        String firstName="Elisabeth";
        customer.setFirstName(firstName);
        assertEquals("FirstName property is not accesible!!!",
                    firstName,customer.getFirstName());
    }
    @Test
    public void testLastNameProperty() {
        String lastName="Williams";
        customer.setLastName(lastName);
        assertEquals("LastName property is not accesible!!!",
                    lastName,customer.getLastName());
    }
    @Test
    public void testMiddleInitialProperty() {
        String middleInitial="R.";
        customer.setMiddleInitial(middleInitial);
        assertEquals("MiddleInitial property is not accesible!!!",
                    middleInitial,customer.getMiddleInitial());
    }
    @Test
    public void testStreetProperty() {
        String street="163rd Street";
        customer.setStreet(street);
        assertEquals("Street property is not accesible!!!",
                    street,customer.getStreet());
    }
    @Test
    public void testCityProperty() {
        String city="New York";
        customer.setCity(city);
        assertEquals("City property is not accesible!!!",
                    city,customer.getCity());
    }
    @Test
    public void testStateProperty() {
        String state="New York";
        customer.setState(state);
        assertEquals("State property is not accesible!!!",
                    state,customer.getState());
    }
    @Test
    public void testZipProperty() {
        Integer zip=10032;
        customer.setZip(zip);
        assertEquals("Zip property is not accesible!!!",
                    zip,customer.getZip());
    }
    @Test
    public void testPhoneProperty() {
        Long phone=212232323l;
        customer.setPhone(phone);
        assertEquals("Phone property is not accesible!!!",
                    phone,customer.getPhone());
    }
    @Test
    public void testEmailProperty() {
        String email="elizabeth.williams@mymail.com";
        customer.setEmail(email);
        assertEquals("Email property is not accesible!!!",
                    email,customer.getEmail());
    }
    @Test
    public void testToString(){
        Long id=1l;
        customer.setId(id);
        String firstName="John";
        customer.setFirstName(firstName); 
        String lastName="Doe";
        customer.setLastName(lastName);
        assertEquals("String value for customer is not as expected!!!",
                    "Customer: ID="+id+" NAME="+firstName+" "+lastName,
                    customer.toString());
    }
    @Test
    public void testHashCode() {
        Long id=666l;
        customer.setId(id);
        assertEquals("hashCode value is not as expected!!!",
                     id.hashCode(),customer.hashCode());
    }
    @Test
    public void testBeanEquality() {
        customer.setId(2l);
        customer.setFirstName("Jane"); 
        customer.setLastName("Doe");
        Customer bean=new Customer();
        bean.setId(2l);
        bean.setFirstName("Jane");
        bean.setLastName("Doe");
        assertEquals("Customers are not equal!!!",
                      customer,bean);
    }
    @Test
    public void testBeanInequality() {
        customer.setId(2l);
        customer.setFirstName("Jane"); 
        customer.setLastName("Doe");
        Customer bean=new Customer();
        bean.setId(1l);
        bean.setFirstName("John");
        bean.setLastName("Foo");
        assertNotEquals("Customers are not equal!!!",
                      customer,bean);
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Log;
import Modelo.Usuario;
import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author clan-
 */
public class DAO_UsuarioNGTest {
    
    public DAO_UsuarioNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of setUser method, of class DAO_Usuario.
     */
    @Test
    public void testSetUser() {
        Usuario user = null;
        DAO_Usuario instance = new DAO_Usuario();
        user.setNombres("SSpapu");
        Boolean expResult = null;
        Boolean result = instance.setUser(user);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class DAO_Usuario.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        DAO_Usuario instance = new DAO_Usuario();
        List expResult = null;
        List result = instance.getUser();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOneUser method, of class DAO_Usuario.
     */
    @Test
    public void testGetOneUser() {
        System.out.println("getOneUser");
        Usuario user = null;
        DAO_Usuario instance = new DAO_Usuario();
        Usuario expResult = null;
        Usuario result = instance.getOneUser(user);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUser method, of class DAO_Usuario.
     */
    @Test
    public void testUpdateUser() {
        System.out.println("updateUser");
        Usuario user = null;
        DAO_Usuario instance = new DAO_Usuario();
        boolean expResult = false;
        boolean result = instance.updateUser(user);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUser method, of class DAO_Usuario.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        Usuario user = null;
        DAO_Usuario instance = new DAO_Usuario();
        boolean expResult = false;
        boolean result = instance.deleteUser(user);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

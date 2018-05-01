/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.Empresa;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author clan-
 */
public class controller_empTest {

    public controller_empTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of registerEmpresa method, of class controller_emp.
     */
    @Test
    public void testRegisterEmpresaTrue() {
        System.out.println("Test de registrarEmpresa");
        Empresa emp = new Empresa();
        emp.setId_emp(1);
        emp.setId_emp_ma(1);
        emp.setNom_emp("Youtube");
        emp.setNom_encargado("Santiago Robledo");
        emp.setDoc_encargado("102657788");
        emp.setTel_encargado("2658995");
        emp.setCor_encargado("snroble@gmail.com");
        emp.setTipo_operacion("Reproduccion");
        emp.setValor_operacion("2");
        emp.setFecha_registro("18/04/2018");

        controller_emp instance = new controller_emp();
        boolean expResult = true;
        boolean result = instance.registerEmpresa(emp);
        assertEquals(expResult, result);

        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testRegisterEmpresaFalse() {
        System.out.println("Test de registrarEmpresa");
        Empresa emp = new Empresa();
        emp.setId_emp(1);
        emp.setId_emp_ma(1);
        emp.setNIT_emp("45233");
        emp.setNom_emp("Youtube");
        emp.setNom_encargado("Santiago Robledo");
        emp.setDoc_encargado("102657788");
        emp.setTel_encargado("2658995");
        emp.setCor_encargado("snroble@gmail.com");
        emp.setTipo_operacion("Reproduccion");
        emp.setValor_operacion("2");
        emp.setFecha_registro("18/04/2018");

        controller_emp instance = new controller_emp();
        boolean expResult = false;
        boolean result = instance.registerEmpresa(emp);
        assertEquals(expResult, result);

        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void DeleteEmpresaTrue() {
        System.out.println("Test de DeleteEmpresa");
        Empresa emp = new Empresa();
        emp.setId_emp(1);
        emp.setId_emp_ma(1);
        controller_emp instance = new controller_emp();
        boolean expResult = true;
        boolean result = instance.deleteEmpresa(emp);
        assertEquals(expResult, result);

        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void DeleteEmpresaFalse() {
        System.out.println("Test de DeleteEmpresa");
        Empresa emp = new Empresa();
        emp.setId_emp(1);
        emp.setId_emp_ma(1);
        controller_emp instance = new controller_emp();
        boolean expResult = false;
        boolean result = instance.deleteEmpresa(emp);
        assertEquals(expResult, result);

        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateEmpresa method, of class controller_emp.
     */
}

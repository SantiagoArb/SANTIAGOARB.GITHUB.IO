/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssmusictest;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author SNT
 */
public class LoginTest {
    private WebDriver driver;
    private final String baseUrl = "http://localhost:17155/SSMusic/Ingreso_Registro/Acceso.jsp";
    private final StringBuffer verificationErrors = new StringBuffer();
    
    
    //Parametros Login
     String usuario = "santiago";
    String contraseña = "1234";
    String loginCorrecto = "Usuario correcto";
    String loginIncorrecto = "Usuario y/o contraseña Incorrecto";
    
    public LoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void Login() throws InterruptedException {
        Login instanceLogin = new Login(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        instanceLogin.Logear(usuario, contraseña);
        TimeUnit.SECONDS.sleep(2);
        String sesion_actual = instanceLogin.validarUsuario();
        assertEquals(sesion_actual,usuario);
    }
    
}

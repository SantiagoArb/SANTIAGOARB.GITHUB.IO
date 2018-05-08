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
    
    //Parametros Empresa
    String nit = "1232323";
   String nombre_emp  = "Youtube";
  String nombre_enc  = "Ramiro";
   String telefono_enc  = "34353333";
   String correo = "ramiro22@gmail.com";
   String tipo_operacion  = "Reproduccion";
   String valor_operacion  = "22";
   String documento_enc = "1029939994";
   
   //ParametrosArtista
   String nombre_art = "Rammstein";
   String nombre_rep  = "Santiago";
   String documento_rep  = "1020475843";
   String telefono_rep = "3245522";
   String correo_rep  = "rmst@gmail.com";
    
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
    
    @Test
    public void RegistrarEmpresa(){
        Login instanceLogin = new Login(driver);
        RegistroEmpresa instanceEmpresa = new RegistroEmpresa(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        instanceLogin.Logear(usuario, contraseña);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        instanceEmpresa.Registrar_Empresa( nit,  nombre_emp,  nombre_enc,  telefono_enc,  correo,  tipo_operacion,  valor_operacion,  documento_enc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       String empresa = instanceEmpresa.ValidarRegistro();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertEquals(empresa,nombre_emp);
    }
    
    @Test
    public void RegistrarArtista(){
        Login instanceLogin = new Login(driver);
        RegistroEmpresa instanceEmpresa = new RegistroEmpresa(driver);
        RegistroArtista instanceArtista = new RegistroArtista(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        instanceLogin.Logear(usuario, contraseña);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        instanceEmpresa.Registrar_Empresa( nit,  nombre_emp,  nombre_enc,  telefono_enc,  correo,  tipo_operacion,  valor_operacion,  documento_enc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        instanceArtista.Registrar_Artista(nombre_art, nombre_rep, documento_rep, telefono_rep, correo_rep);
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String artista = instanceArtista.validarArtista();
        assertEquals(artista,nombre_art);
    }
    
    
}

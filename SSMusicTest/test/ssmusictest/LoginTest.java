/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssmusictest;

import java.util.Random;
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
    Random r = new Random();
    int n = 999;
    int random = (int) (Math.random() * n) + 1;
    char randomchar = (char)(r.nextInt(26) + 'a');
    
    //Parametros Login
     String usuario = "santiago";
    String contraseña = "1234";
    String loginCorrecto = "Usuario correcto";
    String loginIncorrecto = "Usuario y/o contraseña Incorrecto";
    
    //Parametros Empresa
    String nit = "12322"+random;
   String nombre_emp  = "Youtube"+randomchar;
  String nombre_enc  = "Ramiro"+randomchar;
   String telefono_enc  = "34353333";
   String correo = "ramiro"+random+"@gmail.com";
   String tipo_operacion  = "Reproduccion";
   String valor_operacion  = "22";
   String documento_enc = "102993999"+random;
   
   //ParametrosArtista
   String nombre_art = "Rammstein"+randomchar;
   String nombre_rep  = "Santiago"+randomchar;
   String documento_rep  = "102047584"+random;
   String telefono_rep = "3245522";
   String correo_rep  = "rmst"+random+"@gmail.com";
   
   //Parametros operacion
   String artista = "Rammstein";
   String cantidad = "4";
   
     //Parametros Operario
   String usuario_op="Lau123"+randomchar;
   String contraseña_op ="1234"; 
   String nombre_op="Laura";
   String apellido1_op="gonzales";
   String apellido2_op = "Restrepo";
   String documento_op = "123323211";
   String correo_op = "lausss@gmail.com";
   String telefono_op= "32323222";
   String direccion_op ="cra 33_222";
   
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
        System.out.println("Inicia Test Login...");
        Login instanceLogin = new Login(driver);
        
        instanceLogin.Logear(usuario, contraseña);
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       String sesion_actual = instanceLogin.validarUsuario();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       assertEquals(sesion_actual,usuario);
    }
    
    @Test
    public void RegistrarEmpresa() throws InterruptedException{
        System.out.println("Inicia Test Registro empresa...");
        Login instanceLogin = new Login(driver);
        RegistroEmpresa instanceEmpresa = new RegistroEmpresa(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        instanceLogin.Logear(usuario, contraseña);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        instanceEmpresa.Registrar_Empresa( nit,  nombre_emp,  nombre_enc,  telefono_enc,  correo,  tipo_operacion,  valor_operacion,  documento_enc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       String empresa = instanceEmpresa.ValidarRegistro(nombre_emp);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertEquals(empresa,nombre_emp);
    }
    
    
    public void actualizarEmpresa() throws InterruptedException{
        Login instanceLogin = new Login(driver);
        RegistroEmpresa instanceEmpresa = new RegistroEmpresa(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        instanceLogin.Logear(usuario, contraseña);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        instanceEmpresa.update_Empresa( nit,  nombre_emp,  nombre_enc,  telefono_enc,  correo,  tipo_operacion,  valor_operacion,  documento_enc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       String empresa = instanceEmpresa.ValidarRegistro(nombre_emp);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertEquals(empresa,nombre_emp);
    }
    
    
    public void EliminarEmpresa() throws InterruptedException{
        Login instanceLogin = new Login(driver);
        RegistroEmpresa instanceEmpresa = new RegistroEmpresa(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        instanceLogin.Logear(usuario, contraseña);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        instanceEmpresa.Registrar_Empresa( nit,  nombre_emp,  nombre_enc,  telefono_enc,  correo,  tipo_operacion,  valor_operacion,  documento_enc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        instanceEmpresa.eliminar_Empresa(nombre_emp);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       String empresa = instanceEmpresa.ValidarRegistro(nombre_emp);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertNotEquals(empresa,nombre_emp);
    }
    
    
    public void RegistrarArtista() throws InterruptedException{
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
        String artista = instanceArtista.ValidarArtista(nombre_art);
        assertEquals(artista,nombre_art);
    }
    
    
    public void ActualizarArtista() throws InterruptedException{
        Login instanceLogin = new Login(driver);
        RegistroEmpresa instanceEmpresa = new RegistroEmpresa(driver);
        RegistroArtista instanceArtista = new RegistroArtista(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        instanceLogin.Logear(usuario, contraseña);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        instanceEmpresa.Registrar_Empresa( nit,  nombre_emp,  nombre_enc,  telefono_enc,  correo,  tipo_operacion,  valor_operacion,  documento_enc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        instanceArtista.update_Artista(nombre_art, nombre_rep, documento_rep, telefono_rep, correo_rep);
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String artista = instanceArtista.ValidarArtista(nombre_art);
        assertEquals(artista,nombre_art);
    }
    
   
    public void eliminarArtista() throws InterruptedException{
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
        instanceArtista.eliminar_artista(nombre_art);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String artista = instanceArtista.ValidarArtista(nombre_art);
        assertNotEquals(artista,nombre_art);
    }
    
    public void IngresarOperacion() throws InterruptedException{
        Login instanceLogin = new Login(driver);
        RegistroEmpresa instanceEmpresa = new RegistroEmpresa(driver);
        RegistroArtista instanceArtista = new RegistroArtista(driver);
        RegistroOperacion instanceOperacion = new RegistroOperacion(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        instanceLogin.Logear(usuario, contraseña);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        instanceEmpresa.Registrar_Empresa( nit,  nombre_emp,  nombre_enc,  telefono_enc,  correo,  tipo_operacion,  valor_operacion,  documento_enc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        instanceArtista.Registrar_Artista(nombre_art, nombre_rep, documento_rep, telefono_rep, correo_rep);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        instanceOperacion.RegistrarOperacion(artista, cantidad);
        assertTrue(instanceOperacion.getValidacion_operacion());
        
    }
    
    @Test
    public void RegistroOperario() throws InterruptedException{
        System.out.println("Inicia Test registro operario...");
        Login instanceLogin = new Login(driver);
        RegistroOperario instanceOperario = new RegistroOperario(driver);
        instanceLogin.Logear(usuario, contraseña);
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       String result = instanceOperario.registrarOperario(usuario_op, contraseña_op, nombre_op, apellido1_op, apellido2_op, documento_op, correo_op, telefono_op, direccion_op );
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       assertEquals(result,"Almacenado con Exito");
    }
    
    
}

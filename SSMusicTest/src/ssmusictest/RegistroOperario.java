/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssmusictest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Softcaribbean-DEV2
 */
public class RegistroOperario {
    WebDriver driver;
     By btn_Moderacion = By.xpath("//*[@id=\"sidebar\"]/ul/li[3]/a");
     By btn_operario = By.xpath("//*[@id=\"sidebar\"]/ul/li[3]/ul/li[4]/a");
     By btn_registrar = By.id("reg_operario");
     By txt_usuario = By.id("USERNAME");
     By txt_contraseña = By.id("PASS");
     By txt_nombres = By.id("NOMBRES");
     By txt_apellidouno = By.id("APELLIDO1");
     By txt_apellidodos = By.id("APELLIDO2");
     By txt_documento = By.id("DOCUMENTO");
     By txt_correo = By.id("CORREO");
     By txt_telefono = By.id("TELEFONO");
     By txt_direccion = By.id("DIRECCION");
     By btn_submit = By.id("RegistroOperario");
     By result_mensaje = By.id("mensaje_Rope");

    public String getResult_mensaje() {
       String text = driver.findElement(result_mensaje).getText();
       return text;
    }
     
     
    public RegistroOperario(WebDriver driver) {
        this.driver = driver;
    }
    
    public void click_btn_Moderacion() {
        driver.findElement(btn_Moderacion).click();
    }
    public void click_btn_submit(){
        driver.findElement(btn_submit).click();
    }

    public void click_Btn_operario() {
        driver.findElement(btn_operario).click();
    }

    public void click_tBtn_registrar() {
        driver.findElement(btn_registrar).click();
    }

    public void setTxt_usuario(String usuario) {
        driver.findElement(txt_usuario).clear();
        driver.findElement(txt_usuario).sendKeys(usuario);
    }

    public void setTxt_contraseña(String contraseña) {
        driver.findElement(txt_contraseña).clear();
        driver.findElement(txt_contraseña).sendKeys(contraseña);
    }

    public void setTxt_nombres(String nombres) {
        driver.findElement(txt_nombres).clear();
        driver.findElement(txt_nombres).sendKeys(nombres);
    }

    public void setTxt_apellidouno(String apellidouno) {
        driver.findElement(txt_apellidouno).clear();
        driver.findElement(txt_apellidouno).sendKeys(apellidouno);
    }

    public void setTxt_apellidodos(String apellidodos) {
        driver.findElement(txt_apellidodos).clear();
        driver.findElement(txt_apellidodos).sendKeys(apellidodos);
    }

    public void setTxt_documento(String documento) {
        driver.findElement(txt_documento).clear();
        driver.findElement(txt_documento).sendKeys(documento);
    }

    public void setTxt_correo(String correo) {
       driver.findElement(txt_correo).clear();
        driver.findElement(txt_correo).sendKeys(correo);
    }

    public void setTxt_telefono(String telefono) {
        driver.findElement(txt_telefono).clear();
        driver.findElement(txt_telefono).sendKeys(telefono);
    }

    public void setTxt_direccion(String direccion) {
        driver.findElement(txt_direccion).clear();
        driver.findElement(txt_direccion).sendKeys(direccion);
    }
    
    public String registrarOperario(String usuario, String contraseña, String nombres, String apellido1, String apellido2, String documento, String correo, String telefono, String direccion) throws InterruptedException{
       TimeUnit.SECONDS.sleep(2);
        this.click_btn_Moderacion();
        TimeUnit.SECONDS.sleep(2);
        this.click_Btn_operario();
        TimeUnit.SECONDS.sleep(2);
        this.click_tBtn_registrar();
        TimeUnit.SECONDS.sleep(2);
        this.setTxt_usuario(usuario);
        this.setTxt_contraseña(contraseña);
        this.setTxt_nombres(nombres);
        this.setTxt_apellidouno(apellido1);
        this.setTxt_apellidodos(apellido2);
        this.setTxt_documento(documento);
        this.setTxt_correo(correo);
        this.setTxt_direccion(direccion);
        this.click_btn_submit();
        TimeUnit.SECONDS.sleep(2);
        return this.getResult_mensaje();
    }
    
    
}

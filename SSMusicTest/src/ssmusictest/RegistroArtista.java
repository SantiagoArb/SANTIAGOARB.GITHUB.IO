/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssmusictest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author SNT
 */
public class RegistroArtista {
    WebDriver driver;
    
    By btn_infoArtistas = By.id("info_artistas");
   By btn_registrar_art = By.id("registrar_art");
   
   
   By txt_nombre_art = By.id("NOM_ARTISTA");
   By txt_nombre_rep  = By.id("NOM_REPRESENTANTE");
   By txt_documento_rep  = By.id("DOC_REPRESENTANTE");
   By txt_telefono_rep = By.id("TEL_REPRESENTANTE");
   By txt_correo  = By.id("COR_REPRESENTANTE");
  
   By submit_registro = By.id("RegistroArtista");
    
    
    public RegistroArtista(WebDriver driver) {
        this.driver = driver;
    }

     public void click_submit_registro() {
        driver.findElement(submit_registro).click();
    }
    
    public void click_btn_infoArtistas() {
        driver.findElement(btn_infoArtistas).click();
    }

    public void clickbtn_registrar_art() {
        driver.findElement(btn_registrar_art).click();
    }

    public void setTxt_nombre_art(String nombre_art) {
        driver.findElement(txt_nombre_art).clear();
        driver.findElement(txt_nombre_art).sendKeys(nombre_art);
    }

    public void setTxt_nombre_rep(String nombre_rep) {
        driver.findElement(txt_nombre_rep).clear();
        driver.findElement(txt_nombre_rep).sendKeys(nombre_rep);
    }

    public void setTxt_documento_rep(String documento_rep) {
        driver.findElement(txt_documento_rep).clear();
        driver.findElement(txt_documento_rep).sendKeys(documento_rep);
    }

    public void setTxt_telefono_rep(String telefono_rep) {
        driver.findElement(txt_telefono_rep).clear();
        driver.findElement(txt_telefono_rep).sendKeys(telefono_rep);
    }

    public void setTxt_correo(String correo) {
        driver.findElement(txt_correo).clear();
        driver.findElement(txt_correo).sendKeys(correo);
    }

    

    public void Registrar_Artista(String nombre_art, String nombre_rep,String documento, String telefono, String correo){
       this.click_btn_infoArtistas();
       this.clickbtn_registrar_art();
       this.setTxt_nombre_art(nombre_art);
       this.setTxt_nombre_rep(nombre_rep);
       this.setTxt_documento_rep(documento);
       this.setTxt_telefono_rep(telefono);
       this.setTxt_correo(correo);
       this.click_submit_registro();
       
    }
    
    public String validarArtista(){
        String text = "";
        return text;
    }
}

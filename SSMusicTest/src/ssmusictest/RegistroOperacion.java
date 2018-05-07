/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssmusictest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author Softcaribbean-DEV2
 */
public class RegistroOperacion {
    WebDriver driver;

   
   By reg_operacion = By.id("btn_operacion");
    By select_id_artista = By.id("ID_ARTISTA_VE");
   By txt_cantidad = By.id("CANTIDAD_OPERACIONES");
   By txt_venta = By.id("VALOR_VENTA");
   By btn_submit = By.id("btn_submit_op");

    public void clickReg_operacion() {
        driver.findElement(reg_operacion).click();
    }
    
    public void setSelect_id_artista(String artista) {
        Select dprArtista = new Select(driver.findElement(select_id_artista));
        dprArtista.selectByVisibleText(artista);
    }

    public void setTxt_cantidad(String cantidad) {
        driver.findElement(txt_cantidad).clear();
        driver.findElement(txt_cantidad).sendKeys(cantidad);
    }

    public void setTxt_venta(String venta) {
        driver.findElement(txt_venta).clear();
        driver.findElement(txt_venta).sendKeys(venta);
    }

    public void clickBtn_submit() {
       driver.findElement(btn_submit).click();
    }
   

    public RegistroOperacion(WebDriver driver) {
        this.driver = driver;
}
    
    public void RegistrarArtista(String artista, String cantidad, String venta){
        this.clickReg_operacion();
        this.setSelect_id_artista(artista);
        this.setTxt_cantidad(cantidad);
        this.setTxt_venta(venta);
        this.clickBtn_submit();
    }
}

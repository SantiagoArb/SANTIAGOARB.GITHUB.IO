/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssmusictest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author SNT
 */
public class RegistroEmpresa {
    WebDriver driver;
    
    By btn_infoEmpresas = By.xpath("//*[@id=\"sidebar\"]/ul/li[3]/ul/li[2]/a");
   By btn_registrar_emp = By.xpath("//*[@id=\"data\"]/header/button");
   By txt_nit = By.id("NIT_EMPRESA_D");
   By txt_nombre_emp  = By.id("NOM_EMPRESA_D");
   By txt_nombre_enc  = By.id("NOM_ENCARGADO_D");
   By txt_telefono_enc  = By.id("TEL_ENCARGADO_D");
   By txt_correo = By.id("COR_ENCARGADO_D");
   By txt_tipo_operacion  = By.id("TIPO_OPERACION_D");
   By txt_valor_operacion  = By.id("VALOR_OPERACION_D");
   By txt_documento_enc = By.id("DOC_ENCARGADO_D");
   By submit_registro = By.id("RegistroEmpresa");
   By txt_buscar = By.xpath("//*[@id=\"table_Empresas_filter\"]/label/input");
   By result_buscar = By.xpath("//*[@id=\"employee_data\"]/tr/td[3]");
   By btn_delete = By.id("eliminar_emp");
   By txt_eliminar = By.id("name_eliminar_emp");
   By btn_submit_delete = By.id("submit_delete");
   By btn_Moderacion = By.xpath("//*[@id=\"sidebar\"]/ul/li[3]/a");
   By btn_close = By.xpath("//*[@id=\"Reg_Empresa\"]/div/div[1]/div/button/span");
    
    
    public RegistroEmpresa(WebDriver driver) {
        this.driver = driver;
    }
    
    public void click_btn_Moderacion() {
        driver.findElement(btn_Moderacion).click();
    }
    
    public void click_btn_close() {
        driver.findElement(btn_close).click();
    }

    public void click_Btn_delete() {
        driver.findElement(btn_delete).click();
    }

    public void click_Btn_submit_delete() {
       driver.findElement(btn_submit_delete).click();
    }

    
    
     public void click_submit_registro() {
        driver.findElement(submit_registro).click();
    }
    
    public void click_Btn_infoEmpresas() {
        driver.findElement(btn_infoEmpresas).click();
    }

    public void click_Btn_registrar_emp() {
        driver.findElement(btn_registrar_emp).click();
    }

    public String getResult_buscar() {
        
        String result = driver.findElement(result_buscar).getText();
        return result;
    }
    
     public void settxt_eliminar(String eliminar) {
         driver.findElement(txt_eliminar).clear();
        driver.findElement(txt_eliminar).sendKeys(eliminar);
    }
    
     public void settxt_buscar(String buscar) {
         driver.findElement(txt_buscar).clear();
        driver.findElement(txt_buscar).sendKeys(buscar);
    }

    public void setTxt_nit(String nit) {
         driver.findElement(txt_nit).clear();
        driver.findElement(txt_nit).sendKeys(nit);
    }

    public void setTxt_nombre_emp(String nombre_emp) {
         driver.findElement(txt_nombre_emp).clear();
        driver.findElement(txt_nombre_emp).sendKeys(nombre_emp);
    }

    public void setTxt_nombre_enc(String nombre_enc) {
         driver.findElement(txt_nombre_enc).clear();
        driver.findElement(txt_nombre_enc).sendKeys(nombre_enc);
    }

    public void setTxt_telefono_enc(String telefono_enc) {
         driver.findElement(txt_telefono_enc).clear();
        driver.findElement(txt_telefono_enc).sendKeys(telefono_enc);
    }

    public void setTxt_correo(String correo) {
         driver.findElement(txt_correo).clear();
        driver.findElement(txt_correo).sendKeys(correo);
    }

    public void setTxt_tipo_operacion(String tipo_operacion) {
         driver.findElement(txt_tipo_operacion).clear();
        driver.findElement(txt_tipo_operacion).sendKeys(tipo_operacion);
    }

    public void setTxt_valor_operacion(String valor_operacion) {
         driver.findElement(txt_valor_operacion).clear();
        driver.findElement(txt_valor_operacion).sendKeys(valor_operacion);
    }

    public void setTxt_documento_enc(String documento_enc) {
         driver.findElement(txt_documento_enc).clear();
        driver.findElement(txt_documento_enc).sendKeys(documento_enc);
    }

    public void Registrar_Empresa(String nit, String nombre_emp, String nombre_enc, String telefono, String correo, String tipo_op, String valor_op, String documento) throws InterruptedException{
        TimeUnit.SECONDS.sleep(2);
        this.click_btn_Moderacion();
        TimeUnit.SECONDS.sleep(2);
        this.click_Btn_infoEmpresas();
        TimeUnit.SECONDS.sleep(2);
        this.click_Btn_registrar_emp();
        TimeUnit.SECONDS.sleep(2);
        this.setTxt_nit(nit);
        this.setTxt_nombre_emp(nombre_emp);
        this.setTxt_nombre_enc(nombre_enc);
        this.setTxt_telefono_enc(telefono);
        this.setTxt_correo(correo);
        this.setTxt_tipo_operacion(tipo_op);
        this.setTxt_valor_operacion(valor_op);
        this.setTxt_documento_enc(documento);
        this.click_submit_registro();
        this.click_btn_close();
    }
    
    public void update_Empresa(String nit, String nombre_emp, String nombre_enc, String telefono, String correo, String tipo_op, String valor_op, String documento){
        this.click_Btn_infoEmpresas();
        this.click_Btn_registrar_emp();
        this.setTxt_nit(nit);
        this.setTxt_nombre_emp(nombre_emp);
        this.setTxt_nombre_enc(nombre_enc);
        this.setTxt_telefono_enc(telefono);
        this.setTxt_correo(correo);
        this.setTxt_tipo_operacion(tipo_op);
        this.setTxt_valor_operacion(valor_op);
        this.setTxt_documento_enc(documento);
        this.click_submit_registro();
    }
    public String ValidarRegistro(String nombre_emp) throws InterruptedException{
        TimeUnit.SECONDS.sleep(2);
        this.click_btn_Moderacion();
        TimeUnit.SECONDS.sleep(2);
        this.click_Btn_infoEmpresas();
        TimeUnit.SECONDS.sleep(2);
        this.settxt_buscar(nombre_emp);
        TimeUnit.SECONDS.sleep(2);
        String result=this.getResult_buscar();
        
        return result;
    }
    public void eliminar_Empresa(String nombre_emp){
        this.click_Btn_delete();
        this.settxt_eliminar(nombre_emp);
        this.click_Btn_submit_delete();
        
    }
}

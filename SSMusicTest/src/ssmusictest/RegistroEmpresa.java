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
public class RegistroEmpresa {
    WebDriver driver;
    
    By btn_infoEmpresas = By.id("info_empresas");
   By btn_registrar_emp = By.id("registrar_emp");
   By txt_nit = By.id("NIT_EMPRESA_D");
   By txt_nombre_emp  = By.id("NOM_EMPRESA_D");
   By txt_nombre_enc  = By.id("NOM_ENCARGADO_D");
   By txt_telefono_enc  = By.id("TEL_ENCARGADO_D");
   By txt_correo = By.id("COR_ENCARGADO_D");
   By txt_tipo_operacion  = By.id("TIPO_OPERACION_D");
   By txt_valor_operacion  = By.id("VALOR_OPERACION_D");
   By txt_documento_enc = By.id("DOC_ENCARGADO_D");
   By submit_registro = By.id("RegistroEmpresa");
    
    
    public RegistroEmpresa(WebDriver driver) {
        this.driver = driver;
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

    public void Registrar_Empresa(String nit, String nombre_emp, String nombre_enc, String telefono, String correo, String tipo_op, String valor_op, String documento){
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
}

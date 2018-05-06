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
public class Login {
    WebDriver driver;

   
   By username = By.id("nick");
   By password = By.id("password");
   By btn_ingreso = By.id("btn_ingreso");
   By p_confirmacion = By.id("P_confirmacion");

    public Login(WebDriver driver) {
        this.driver = driver;
    }
    public void setUsername(String user) {
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);
    }

    public void setPassword(String pass) {
       driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
    }

    public void clickBtn_ingreso() {
        driver.findElement(btn_ingreso).click();
    }

   public String getP_confirmacion() {
        String confirm = driver.findElement(p_confirmacion).getText();
        return confirm;
    }
    
    public void Logear(String user, String pass){
        System.out.println("Entro a logear");
        this.setUsername(user);
        this.setPassword(pass);
        this.clickBtn_ingreso();
        
       
    }
   
           
}

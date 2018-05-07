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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


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
   By info_perfil = By.xpath("/html/body/header/div[2]/ul/li/ul/li[1]/a");
   By username_perfil = By.xpath("//*[@id=\"main-content\"]/section/div[2]/div/div/div/div[1]/h4");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void clickInfo_perfil() {
        driver.findElement(info_perfil).click();
    }

    public String getUsername_perfil() {
        String text = driver.findElement(username_perfil).getText();
        return text;
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
        WebElement ur = driver.findElement(username);
        WebElement pw = driver.findElement(password);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(ur));
        wait.until(ExpectedConditions.visibilityOf(pw));
        System.out.println("Entro a logear");
        this.setUsername(user);
        this.setPassword(pass);
        this.clickBtn_ingreso();
        
       
    }
    
    public String validarUsuario(){
        System.out.println("Entro a validar");
        WebDriverWait wait = new WebDriverWait(driver, 20);
         WebElement info = driver.findElement(info_perfil);
        
        
        wait.until(ExpectedConditions.visibilityOf(info));
        this.clickInfo_perfil();
        WebElement usr = driver.findElement(username_perfil);
        wait.until(ExpectedConditions.visibilityOf(usr));
        
        
        return this.getUsername_perfil();
    }
   
           
}

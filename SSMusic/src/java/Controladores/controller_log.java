/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.DAO_Log;
import DAO.ILog_DAO;
import Modelo.Log;
import java.text.ParseException;

/**
 *
 * @author Softcaribbean-DEV2
 */
public class controller_log {

    public controller_log() {
    }
    
    public void registerLog(Log log){
        ILog_DAO udao = new DAO_Log();
        udao.setLog(log);
    }
}

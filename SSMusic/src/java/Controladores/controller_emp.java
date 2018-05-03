/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.DAO_Empresa;
import DAO.IEmpresa_DAO;
import Modelo.Empresa;
import Modelo.Log;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author clan-
 */
public class controller_emp {

    public controller_emp() {
    }

    public boolean registerEmpresa(Empresa emp, Log log) {
        IEmpresa_DAO edao = new DAO_Empresa();
        boolean result = edao.setEmpresa(emp, log);
        return result;
    }

    public boolean updateEmpresa(Empresa emp) {
        IEmpresa_DAO edao = new DAO_Empresa();
        boolean result = edao.updateEmpresa(emp);
        return result;
    }

    public boolean deleteEmpresa(Empresa emp, Log log) {
        IEmpresa_DAO edao = new DAO_Empresa();
        boolean result = edao.deleteEmpresa(emp, log);
        return result;
    }

    public ArrayList<Empresa> getEmpresas() {
        ArrayList<Empresa> emps = new ArrayList<Empresa>();
        IEmpresa_DAO edao = new DAO_Empresa();
        emps = edao.getEmpresa();
        return emps;
    }
}

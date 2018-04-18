/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.DAO_Empresa;
import DAO.IEmpresa_DAO;
import Modelo.Empresa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author clan-
 */
public class controller_emp {

    public controller_emp() {
    }

    public void registerEmpresa(Empresa emp) {
        IEmpresa_DAO edao = new DAO_Empresa();
        edao.setEmpresa(emp);
    }

    public void updateEmpresa(Empresa emp) {
        IEmpresa_DAO edao = new DAO_Empresa();
        edao.updateEmpresa(emp);
    }

    public void deleteEmpresa(Empresa emp) {
        IEmpresa_DAO edao = new DAO_Empresa();
        edao.deleteEmpresa(emp);
    }

    public List<Empresa> getEmpresas() {
        List<Empresa> emps = new ArrayList<Empresa>();
        IEmpresa_DAO edao = new DAO_Empresa();
        emps = edao.getEmpresa();
        return emps;
    }
}

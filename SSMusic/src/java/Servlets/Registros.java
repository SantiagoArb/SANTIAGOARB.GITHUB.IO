/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controladores.controller_art;
import Controladores.controller_emp;
import DAO.IEmpresa_DAO;
import Metodos.Calendario;
import Modelo.Artista;
import Modelo.Empresa;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author clan-
 */
public class Registros extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registros</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Registros at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getParameter("RegistroEmpresa") != null) {
            RegistroEmpresa(request, response);
        };
        if(request.getParameter("RegistroArtista") != null) {
            RegistroArtista(request, response);
        };

    }

    public void RegistroEmpresa(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
        Calendario fechaR = new Calendario();
        String FECHA_REGISTRO = fechaR.Fecha_Registro();
        HttpSession res = request.getSession(true);
        Empresa emp = new Empresa();
        emp.setId_emp(1);
        emp.setId_emp_ma(1);
        emp.setNIT_emp(request.getParameter("NIT_EMPRESA_D"));
        emp.setNom_emp(request.getParameter("NOM_EMPRESA_D"));
        emp.setNom_encargado(request.getParameter("NOM_ENCARGADO_D"));
        emp.setDoc_encargado(request.getParameter("DOC_ENCARGADO_D"));
        emp.setTel_encargado(request.getParameter("TEL_ENCARGADO_D"));
        emp.setCor_encargado(request.getParameter("COR_ENCARGADO_D"));
        emp.setTipo_operacion(request.getParameter("TIPO_OPERACION_D"));
        emp.setValor_operacion(request.getParameter("VALOR_OPERACION_D"));
        emp.setFecha_registro(FECHA_REGISTRO);
        controller_emp edao = new controller_emp();
        boolean result = edao.registerEmpresa(emp);
        if (!result) {
            res.setAttribute("ErrorRegistroEmp", "NO GUARDO");
            response.sendRedirect("Interfaz/Admin/Gestion.jsp");
        } else {
            res.setAttribute("ErrorRegistroEmp", "Guardo");
            response.sendRedirect("Interfaz/Admin/Gestion.jsp");

        }

    }
    catch(Exception e){
     System.out.println(e);
}
    }

    ;
    
    public void RegistroArtista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Calendario fechaR = new Calendario();
        String FECHA_REGISTRO = fechaR.Fecha_Registro();
        HttpSession res = request.getSession(true);
        Artista art = new Artista();
        art.setId(1);
        art.setNombre_art(request.getParameter("NOM_ARTISTA"));
        art.setNom_representante(request.getParameter("NOM_REPRESENTANTE"));
        art.setDoc_representante(request.getParameter("DOC_REPRESENTANTE"));
        art.setTel_representante(request.getParameter("TEL_REPRESENTANTE"));
        art.setCor_representante(request.getParameter("COR_REPRESENTANTE"));
        art.setId_empresa_d_art(26);
        art.setFecha_registro_art("19/04/2018");
        
        

        controller_art adao = new controller_art();
        boolean result = adao.registerArt(art);
        if (!result) {
            res.setAttribute("ErrorRegistroArt", "NO GUARDO");
            response.sendRedirect("Interfaz/Admin/Gestion.jsp");
        } else {
            res.setAttribute("ErrorRegistroArt", "Guardo");
            response.sendRedirect("Interfaz/Admin/Gestion.jsp");

        }
    };
             
             
             
             

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

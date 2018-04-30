/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controladores.controller_art;
import Controladores.controller_emp;
import Controladores.controller_user;
import DAO.IEmpresa_DAO;
import Metodos.Calendario;
import Modelo.Artista;
import Modelo.Empresa;
import Modelo.Usuario;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
            response.setContentType("text/html");
        response.getWriter().write(RegistroEmpresa(request,response));
        };
        if(request.getParameter("RegistroArtista") != null) {
            response.setContentType("text/html");
        response.getWriter().write(RegistroArtista(request,response));
        };
        if(request.getParameter("listarEmpresa") != null) {
            response.setContentType("text/html");
        response.getWriter().write(listarEmpresas(request,response));
        };
        if(request.getParameter("RegistroOperario") != null) {
            response.setContentType("text/html");
        response.getWriter().write(RegistroOperario(request,response));
        };

    }

    public String RegistroEmpresa(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         com.google.gson.JsonObject json = new JsonObject();
         JsonObject item = new JsonObject();
        try{
          
        Calendario fechaR = new Calendario();
        String FECHA_REGISTRO = fechaR.Fecha_Registro();
        
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
        
        item.addProperty("result", result);
        

    }
    catch(Exception e){
     System.out.println(e);
    }
      return item.toString();  
    };
    
    public String RegistroArtista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         JsonObject item = new JsonObject();
        try{
        Calendario fechaR = new Calendario();
        String FECHA_REGISTRO = fechaR.Fecha_Registro();
       
        Artista art = new Artista();
        art.setId(1);
        art.setNombre_art(request.getParameter("NOM_ARTISTA"));
        art.setNom_representante(request.getParameter("NOM_REPRESENTANTE"));
        art.setDoc_representante(request.getParameter("DOC_REPRESENTANTE"));
        art.setTel_representante(request.getParameter("TEL_REPRESENTANTE"));
        art.setCor_representante(request.getParameter("COR_REPRESENTANTE"));
        art.setId_empresa_d_art(Integer.parseInt(request.getParameter("ID_EMPRESA_D_ART")));
        art.setFecha_registro_art("01/04/2017");
        
        controller_art adao = new controller_art();
        boolean result = adao.registerArt(art);
        item.addProperty("result", result);
        
        }catch(Exception e){
            System.out.println(e);
        }
        return item.toString();  
    };
    
    public String listarEmpresas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         com.google.gson.JsonObject json = new JsonObject();
         JsonArray array = new JsonArray();
         ArrayList<Modelo.Empresa> resultado;
         
         
        try{
         
        
        controller_emp edao = new controller_emp();
        
         resultado = edao.getEmpresas();
        for(Empresa result:resultado){
            JsonObject item = new JsonObject();
            item.addProperty("ID_EMPRESA_D",result.getId_emp() );
        item.addProperty("ID_EMAYOR", result.getId_emp_ma());
        item.addProperty("NIT_EMPRESA_D", result.getNIT_emp());
        item.addProperty("NOM_EMPRESA_D", result.getNom_emp());
        item.addProperty("NOM_ENCARGADO_D", result.getNom_encargado());
        item.addProperty("DOC_ENCARGADO_D", result.getDoc_encargado());
        item.addProperty("TEL_ENCARGADO_D", result.getTel_encargado());
        item.addProperty("COR_ENCARGADO_D", result.getCor_encargado());
        item.addProperty("TIPO_OPERACION_D", result.getTipo_operacion());
        item.addProperty("VALOR_OPERACION_D",result.getValor_operacion());
        item.addProperty("FECHA_REGISTRO_D",result.getFecha_registro());
        array.add(item);
        }
    }
    catch(Exception e){
     System.out.println(e);
    }
      return array.toString();  
    };
    
    public String RegistroOperario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JsonObject item = new JsonObject();
        try{
          
        Calendario fechaR = new Calendario();
        String FECHA_REGISTRO = fechaR.Fecha_Registro();
        System.out.println("fecha en servlet: "+FECHA_REGISTRO);
        Usuario user = new Usuario();
        user.setId(1);
        user.setId_empresa(46);
       user.setTipo_perfil("Operario");
       user.setUsername(request.getParameter("USERNAME"));
       user.setPass(request.getParameter("PASS"));
       user.setNombres(request.getParameter("NOMBRES"));
       user.setApellido1(request.getParameter("APELLIDO1"));
       user.setApellido2(request.getParameter("APELLIDO2"));
       user.setDocumento(request.getParameter("DOCUMENTO"));
       user.setCorreo(request.getParameter("CORREO"));
       user.setTelefono(request.getParameter("TELEFONO"));
       user.setDireccion(request.getParameter("DIRECCION"));
       user.setFecha_registro(FECHA_REGISTRO);
       controller_user edao = new controller_user();
       boolean result = edao.registerUser(user);
        
        item.addProperty("result", result);
        

    }
    catch(Exception e){
     System.out.println(e);
    }
      return item.toString();  
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controladores.controller_art;
import Controladores.controller_emp;
import Modelo.Empresa;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author clan-
 */
public class Datos extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Datos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Datos at " + request.getContextPath() + "</h1>");
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
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(jsonEmpresas());
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
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String jsonEmpresas() {
        controller_emp empresas = new controller_emp();
        List<Empresa> listEmp = empresas.getEmpresas();
        com.google.gson.JsonObject json = new JsonObject();

        JsonArray array = new JsonArray();
        for (Empresa x : listEmp) {
            JsonObject item = new JsonObject();
            item.addProperty("id", x.getId_emp());
            item.addProperty("NIT_Empresa", x.getNIT_emp());
            item.addProperty("Nom_Empresa", x.getNom_emp());
            item.addProperty("Tipo_operacion", x.getTipo_operacion());
            item.addProperty("Valor_operacion", x.getValor_operacion());
            item.addProperty("acciones", ""
                    + "<div class='btn-group'>"
                    + "<button type='button' id='" + x.getId_emp() + "' style='width:40px; height:34px' title='Modificar Registro' class='btn btn-xs btn-primary' data-toggle='modal' data-target='#Modal_RegistrarEmp' data-id='1' data-accion='Observacion'> <i class='icon_pencil-edit'></i></button> "
                    + "<button type='button' id='" + x.getId_emp() + "' style='width:40px; height:34px' title='Eliminar Registro' class='btn btn-xs btn-danger btn_delete' data-toggle='modal' data-target='#ModalEliminar' data-id='1' data-accion='Eliminar'><i class='icon_trash'></i></button>"
                    + "</div>");
            
            item.addProperty("DOC_ENCARGADO_D", x.getDoc_encargado());
            item.addProperty("NOM_ENCARGADO_D", x.getNom_encargado());
            item.addProperty("TEL_ENCARGADO_D", x.getTel_encargado());
            item.addProperty("COR_ENCARGADO_D", x.getCor_encargado());
            item.addProperty("FECHA_REGISTRO_D", x.getFecha_registro());
            array.add(item);
        }
        json.add("Empresas", array);
        return json.toString();
    }

    private String jsonArtistas() {
        com.google.gson.JsonObject json = new JsonObject();
        ArrayList<Modelo.Artista> list;

        controller_art adao = new controller_art();

        JsonArray array = new JsonArray();

        list = adao.getUsers();
        for (Modelo.Artista resultado : list) {

            JsonObject item = new JsonObject();
            item.addProperty("ID_ARTISTA", resultado.getId());
            item.addProperty("NOM_ARTISTA", resultado.getNombre_art());
            item.addProperty("NOM_REPRESENTANTE", resultado.getNom_representante());
            item.addProperty("DOC_REPRESENTANTE", resultado.getDoc_representante());
            item.addProperty("TEL_REPRESENTANTE", resultado.getTel_representante());
            item.addProperty("COR_REPRESENTANTE", resultado.getCor_representante());
            item.addProperty("ID_EMPRESA_D_ART", resultado.getId_empresa_d_art());
            item.addProperty("FECHA_REGISTRO_ART", resultado.getFecha_registro_art());
            item.addProperty("src", resultado.getSrc());
            array.add(item);
        }
        System.out.println("Json artistas: " + array);
        json.add("Artistas", array);
        return json.toString();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controladores.controller_user;
import Modelo.Usuario;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author scardonas
 */
public class Otro extends HttpServlet {

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
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            controller_user usuarios = new controller_user();
            List<Usuario> users = usuarios.getUsers();
            com.google.gson.JsonObject json = new JsonObject();

            JsonArray array = new JsonArray();
            for (Usuario x : users) {
                JsonObject item = new JsonObject();
                item.addProperty("id", x.getId());
                item.addProperty("nombres", x.getNombres());
                item.addProperty("apellido1", x.getApellido1());
                item.addProperty("acciones", ""
                        + "<div class='btn-group'>"
                        + "<button type='button' id='"+x.getId()+"' style='width:40px; height:34px' title='Modificar Registro' class='btn btn-xs btn-primary' data-toggle='modal' data-target='#Modal_RegistrarEmp' data-id='1' data-accion='Observacion'> <i class='icon_pencil-edit'></i></button> "
                        + "<button type='button' id='"+x.getId()+"' style='width:40px; height:34px' title='Eliminar Registro' class='btn btn-xs btn-danger btn_delete' data-toggle='modal' data-target='#ModalEliminar' data-id='1' data-accion='Eliminar'><i class='icon_trash'></i></button>"
                        + "</div>");
                array.add(item);
            }
            json.add("datos", array);
            out.print(json);
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
        processRequest(request, response);
        
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
       processRequest(request, response);
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

}

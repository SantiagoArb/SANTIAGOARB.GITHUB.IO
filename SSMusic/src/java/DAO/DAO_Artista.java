/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.DBUtil;
import Modelo.Artista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author scardonas
 */
public class DAO_Artista implements IArtista_DAO {

    @Override
    public boolean setArtista(Artista art) {
        boolean registrar = true;

        Connection con = null;
        String sql = "INSERT INTO ARTISTA"
                + "("
                + "ID_ARTISTA, "
                + "NOM_ARTISTA, "
                + "NOM_REPRESENTANTE, "
                + "DOC_REPRESENTANTE, "
                + "TEL_REPRESENTANTE, "
                + "COR_REPRESENTANTE, "
                + "ID_EMPRESA_D_ART, "
                + "FECHA_REGISTRO_ART"
                + ") "
                + "VALUES(?,?,?,?,?,?,?,?)";

        try {
            con = DBUtil.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,art.getId());
            ps.setString(2, art.getNombre_art());
            ps.setString(3, art.getNom_representante());
            ps.setString(4, art.getDoc_representante());
            ps.setString(5, art.getTel_representante());
            ps.setString(6, art.getCor_representante());
            ps.setInt(7,art.getId_empresa_d_art());
            ps.setString(8,art.getFecha_registro_art());
            ps.executeQuery();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error: Clase DAO_Artista, método registrar");
            ex.printStackTrace();
            registrar = false;
        }
        
        return registrar;
    }
    

    @Override
    public ArrayList<Artista> getArtistas() {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM ARTISTA ORDER BY NOM_ARTISTA ASC";
        ArrayList<Artista> listaArtista = new ArrayList<Artista>();

        try {
            co = DBUtil.getConexion();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Artista art = new Artista();
                art.setId(rs.getInt("ID_ARTISTA"));
                art.setNombre_art(rs.getString("NOM_ARTISTA"));
                art.setNom_representante(rs.getString("NOM_REPRESENTANTE"));
                art.setDoc_representante(rs.getString("DOC_REPRESENTANTE"));
                art.setTel_representante(rs.getString("TEL_REPRESENTANTE"));
                art.setCor_representante(rs.getString("COR_REPRESENTANTE"));
                art.setId_empresa_d_art(rs.getInt("ID_EMPRESA_D_ART"));
                art.setSrc(rs.getString("src"));
                listaArtista.add(art);
            }
            stm.close();
            rs.close();
            co.close();

        } catch (SQLException ex) {
            System.out.println("Error: Clase DAO_Artista, método obtener");
            ex.printStackTrace();
        }
        return listaArtista;
    }

    @Override
    public boolean deleteArtista(Artista art) {
        boolean eliminar = false;
        Connection con = null;

        String sql = "DELETE FROM ARTISTA WHERE NOM_ARTISTA = ?";

        try {
            con = DBUtil.getConexion();;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, art.getNombre_art());
            ps.executeQuery();
            ps.close();
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Artista, método eliminar");
            e.printStackTrace();
        }
        return eliminar;

    }

    @Override
    public boolean updateArtista(Artista art) {
        boolean actualizar = false;
        Connection con = null;

        String sql = "UPDATE ARTISTA SET "
                + "NOM_ARTISTA = ?, "
                + "NOM_REPRESENTANTE = ?, "
                + "DOC_REPRESENTANTE = ?, "
                + "TEL_REPRESENTANTE = ?, "
                + "COR_REPRESENTANTE = ?, "
                + "WHERE NOM_ARTISTA = ?";
          try {
            con = DBUtil.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, art.getNombre_art());
            ps.setString(2, art.getNom_representante());
            ps.setString(3, art.getDoc_representante());
            ps.setString(4, art.getTel_representante());
            ps.setString(5, art.getCor_representante());
            ps.setString(6, art.getNombre_art());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_ARTISTA, método eliminar");
            e.printStackTrace();
        }
        actualizar = true;
        return actualizar;

    }

}

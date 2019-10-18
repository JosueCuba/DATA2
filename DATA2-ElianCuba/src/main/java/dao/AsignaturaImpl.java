/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Asignatura;


/**
 *
 * @author PC06
 */
public class AsignaturaImpl extends Conexion implements ICRUD<Asignatura> {

    @Override
    public void registrar(Asignatura modelo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Asignatura modelo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Asignatura modelo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Asignatura> listar() throws Exception {
        String sql = "SELECT * FROM ASIGNATURA  ORDER BY CLVASIGN ASC";
        List<Asignatura> listado;
        Asignatura per;
        try {
            listado = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                per = new Asignatura();
                per.setCLVASIGN(rs.getInt("CLVASIGN"));
                per.setCODASIGN(rs.getString("CODASIGN"));
                per.setNOMBASIGN(rs.getString("NOMBASIGN"));
                per.setTT_HT(rs.getInt("TT_HT"));
                per.setTT_HP(rs.getInt("TT_HP"));
                per.setCLVAREA(rs.getInt("CLVAREA"));
                listado.add(per);
            }
            st.close();
            rs.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en listar Dao"+e.getMessage());
            throw e;
        } finally {
            this.cerrar();
        }
        return listado;
    }
}

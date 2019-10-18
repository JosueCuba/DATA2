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
import model.Profesor;

/**
 *
 * @author josue
 */
public class ProfesorImpl extends Conexion implements ICRUD<Profesor> {

    @Override
    public void registrar(Profesor modelo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Profesor modelo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Profesor modelo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Profesor> listar() throws Exception {
        String sql = "SELECT * FROM PROFESOR  ORDER BY CLVPROF ASC";
        List<Profesor> listado;
        Profesor per;
        try {
            listado = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                per = new Profesor();
                per.setCLVPROF(rs.getInt("CLVPROF"));
                per.setNOMBPROF(rs.getString("NOMBPROF"));
                per.setCODPROF(rs.getString("CODPROF"));
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

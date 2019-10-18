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
import model.Departamento;
import model.Profesor;

/**
 *
 * @author josue
 */
public class DepartamentoImpl extends Conexion implements ICRUD<Departamento> {

    @Override
    public void registrar(Departamento modelo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Departamento modelo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Departamento modelo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Departamento> listar() throws Exception {
         String sql = "SELECT * FROM DEPARTAMENTO  ORDER BY CLVDPTO DESC";
        List<Departamento> listado;
        Departamento per;
        try {
            listado = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                per = new Departamento();
                per.setCLVDPTO(rs.getInt("CLVDPTO"));
                per.setNOMBDPTO(rs.getString("NOMBDPTO"));
                per.setCODDPTO(rs.getString("CODDPTO"));
                System.out.println(rs.getString("NOMBDPTO"));
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


package org.uv.practicaweb02;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DAODepartamento implements IDAOGeneral<Departamento, Integer>{

    private ConexionDB con;

    public DAODepartamento() {
        con = ConexionDB.getInstance();
    }

    @Override
    public boolean guardar(Departamento pojo) {
        String sql = "insert into departamento (clave, nombre) "
                + "values('" + pojo.getClave() + "','" + pojo.getNombre() + "')";
        return con.execute(sql);
    }

    @Override
    public boolean modificar(Departamento pojo, Integer id) {
        String sql = "update departamento set nombre ='" + pojo.getNombre()
                 + "' where clave = '" + pojo.getClave() + "'";
        return con.execute(sql);
    }

    @Override
    public boolean eliminar(Integer id) {
        String sql = "delete from departamento where clave = '" + id + "'";
        return con.execute(sql);
    }

    @Override
    public Departamento buscarById(Integer id) {
        try {
            String sql = "Select * from Departamento where clave = '" + id + "'";
            Departamento Departamento = new Departamento();
            ResultSet reg = con.query(sql);
            if (reg.next()) {
                Departamento.setClave(reg.getInt("clave"));
                Departamento.setNombre(reg.getString("nombre"));
                return Departamento;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAODepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Departamento> buscarTodos() {
        try {
            String sql = "Select * from Departamento";
            List<Departamento> lstDepartamento = new ArrayList<>();

            ResultSet reg = con.query(sql);
            while (reg.next()) {
                Departamento Departamento = new Departamento();
                Departamento.setClave(reg.getInt("clave"));
                Departamento.setNombre(reg.getString("nombre"));
                lstDepartamento.add(Departamento);
            }
            return lstDepartamento;

        } catch (SQLException ex) {
            Logger.getLogger(DAODepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

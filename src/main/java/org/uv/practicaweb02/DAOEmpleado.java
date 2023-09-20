
package org.uv.practicaweb02;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOEmpleado implements IDAOGeneral<Empleado, Integer> {

    private ConexionDB con;

    public DAOEmpleado() {
        con = ConexionDB.getInstance();
    }

    @Override
    public boolean guardar(Empleado pojo) {
        String sql = "insert into empleado (clave, nombre, direccion, telefono) "
                + "values('" + pojo.getClave() + "','" + pojo.getNombre() + "',"
                + "'" + pojo.getDireccion() + "','" + pojo.getTelefono() + "')";
        return con.execute(sql);
    }

    @Override
    public boolean modificar(Empleado pojo, Integer id) {
        String sql = "update empleado set nombre ='" + pojo.getNombre()
                + "', direccion ='" + pojo.getDireccion() + "', telefono = '" + pojo.getTelefono() + "' where clave = '" + pojo.getClave() + "'";
        return con.execute(sql);
    }

    @Override
    public boolean eliminar(Integer id) {
        String sql = "delete from empleado where clave = '" + id + "'";
        return con.execute(sql);
    }

    @Override
    public Empleado buscarById(Integer id) {
        try {
            String sql = "Select * from empleado where clave = '" + id + "'";
            Empleado empleado = new Empleado();
            ResultSet reg = con.query(sql);
            if (reg.next()) {
                empleado.setClave(reg.getInt("clave"));
                empleado.setNombre(reg.getString("nombre"));
                empleado.setDireccion(reg.getString("direccion"));
                empleado.setTelefono(reg.getString("telefono"));
                return empleado;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Empleado> buscarTodos() {
        try {
            String sql = "Select * from empleado";
            List<Empleado> lstEmpleado = new ArrayList<>();

            ResultSet reg = con.query(sql);
            while (reg.next()) {
                Empleado empleado = new Empleado();
                empleado.setClave(reg.getInt("clave"));
                empleado.setNombre(reg.getString("nombre"));
                empleado.setDireccion(reg.getString("direccion"));
                empleado.setTelefono(reg.getString("telefono"));
                lstEmpleado.add(empleado);
            }
            return lstEmpleado;

        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}

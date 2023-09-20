
package org.uv.practicaweb02;

import java.util.List;

public class PracticaWeb02 {

    public static void main(String[] args) {
        /* AGREGAR EMPLEADO*/
        //Empleado emp = new Empleado();
        //emp.setClave(5);
        //emp.setNombre("Paul");
        //emp.setDireccion("AV 33");
        //emp.setTelefono("71422");
        //IDAOGeneral<Empleado, Integer> dao = FactoryDAO.create(FactoryDAO.TYPE.EMPLEADO);
        
        
        //dao.guardar(emp);         //Guardar empleado
        //List<Empleado> lstEmpleado = dao.buscarTodos();
        //for(Empleado empleado1 : lstEmpleado){
        //    System.out.println("Nombre: " + empleado1.getNombre());
        //}
        
        /*AGREGAR DEPARTAMENTO*/
        Departamento dep= new Departamento();
        dep.setClave(1);
        dep.setNombre("soriana");
        IDAOGeneral<Departamento, Integer> dao1 = FactoryDAO.create(FactoryDAO.TYPE.DEPARTAMENTO);
        
        dao1.guardar(dep);
        
        System.out.println("Departamento: " + dep.getNombre());
        
        List<Departamento> lstDepartamento = dao1.buscarTodos();
        for(Departamento departamento1 : lstDepartamento){
            System.out.println("Nombre: " + departamento1.getNombre());
        }
        
        
        //Empleado empleado = dao.buscarById(10);
        //System.out.println("Nombre: " + empleado.getNombre());
        //dao.modificar(emp, 10);
        //Empleado empleado2 = dao.buscarById(10);
        //System.out.println("Nombre: " + empleado2.getNombre());
        //dao.eliminar(2);
        //dao1.eliminar(1);
    }
}

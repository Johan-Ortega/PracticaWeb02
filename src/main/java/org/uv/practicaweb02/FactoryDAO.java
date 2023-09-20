
package org.uv.practicaweb02;


public class FactoryDAO {
    public enum TYPE{EMPLEADO, DEPARTAMENTO}
    
    public static IDAOGeneral create(TYPE type){
        IDAOGeneral dao = null;
        switch (type) {
            case DEPARTAMENTO:
                dao=new DAODepartamento();
                break;
            case EMPLEADO:
                dao=new DAOEmpleado();
                break;
        }
        return dao;
    }
}

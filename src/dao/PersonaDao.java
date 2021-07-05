package dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import configs.Database;
import modelo.Persona;

public class PersonaDao extends Database{

    public PersonaDao() {
        
    }
    
    public List<Persona> listar(){
        ConnectionSource con = null;
        List<Persona> list = new ArrayList<Persona>();
        try {
            con = this.getConnection();
            Dao<Persona, String> personaDao =
                    DaoManager.createDao(con, Persona.class);
            return personaDao.queryForAll();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            try {
                con.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return list;
    }
    
    public void crear(Persona persona){
        ConnectionSource con = null;
        try {
            con = this.getConnection();
            Dao<Persona, String> personaDao =
                    DaoManager.createDao(con, Persona.class);
            personaDao.create(persona);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            try {
                con.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public Persona obtener(int dni){
        ConnectionSource con = null;
        Persona persona = null;
        try {
            con = this.getConnection();
            Dao<Persona, String> personaDao =
                    DaoManager.createDao(con, Persona.class);
            
            /*QueryBuilder<Persona, String> queryBuilder = 
                    personaDao.queryBuilder();
            queryBuilder.where().eq(Persona.PERSONA_DNI, String.valueOf(dni));
            PreparedQuery<Persona> preparedQuery = queryBuilder.prepare();
            persona = personaDao.queryForFirst(preparedQuery);
            */
            persona = personaDao.queryBuilder()
                    .where().eq(Persona.PERSONA_DNI, String.valueOf(dni))
                    .queryForFirst();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            try {
                con.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return persona;
    }
    
    public void eliminar(Persona persona){
        ConnectionSource con = null;
        try {
            con = this.getConnection();
            Dao<Persona, String> personaDao =
                    DaoManager.createDao(con, Persona.class);
            personaDao.delete(persona);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            try {
                con.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void actualizar(Persona persona){
        ConnectionSource con = null;
        try {
            con = this.getConnection();
            Dao<Persona, String> personaDao =
                    DaoManager.createDao(con, Persona.class);
            personaDao.update(persona);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            try {
                con.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

package dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
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
}

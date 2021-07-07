package dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import configs.Database;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Lugar;

public class LugarDao extends Database{

    public LugarDao() {
        
    }
    
    public List<Lugar> listar(){
        ConnectionSource con = null;
        List<Lugar> list = new ArrayList<Lugar>();
        try {
            con = this.getConnection();
            Dao<Lugar, String> lugarDao =
                    DaoManager.createDao(con, Lugar.class);
            return lugarDao.queryForAll();
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
    
    public void refrescar(Lugar lugar){
        ConnectionSource con = null;
        try {
            con = this.getConnection();
            Dao<Lugar, String> lugarDao =
                    DaoManager.createDao(con, Lugar.class);
            lugarDao.refresh(lugar);
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

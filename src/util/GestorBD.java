package util;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.TableUtils;
import configs.Database;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Lugar;

public class GestorBD {
    public static void main(String[] args) {
        ConnectionSource con = null;
        try{
            con = (new Database()).getConnection();
            
            //migrate
            List<DatabaseFieldConfig> fieldConfigs =
               new ArrayList<DatabaseFieldConfig>();
            fieldConfigs.add(new DatabaseFieldConfig("id", null,
               DataType.UNKNOWN, null, 0, false, false, true, null,
               false, null, false, null, false, null, false, null,
               null, false, 0, 0));
            fieldConfigs.add(new DatabaseFieldConfig("nombre"));
            DatabaseTableConfig<Lugar> tableConfig = 
                new DatabaseTableConfig<Lugar>(Lugar.class, "lugar" ,fieldConfigs);
            TableUtils.createTableIfNotExists(con, tableConfig);
            
            //seed
            Dao<Lugar, String> dao = DaoManager.createDao(con, Lugar.class);
            List<Lugar> list = dao.queryForAll();
            if(list.isEmpty()){
                String[] ciudades = {
                    "Amazonas",
                    "Ancash",
                    "Apurimac",
                    "Arequipa",
                    "Ayacucho",
                    "Cajamarca",
                    "Callao",
                    "Cusco",
                    "Huancavelica",
                    "Huanuco",
                    "Ica",
                    "Junin",
                    "La Libertad",
                    "Lambayeque",
                    "Lima",
                    "Loreto",
                    "Madre De Dios",
                    "Moquegua",
                    "Pasco",
                    "Piura",
                    "Puno",
                    "San Martin",
                    "Tacna",
                    "Tumbes",
                    "Ucayali"
                };
                for (String ciudad : ciudades) {
                    dao.create(new Lugar(ciudad));
                }
            }
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

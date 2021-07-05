package modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "persona")
public class Persona {
    public static final String PERSONA_DNI = "dni";
    
    @DatabaseField(id = true)
    private int dni;
    @DatabaseField
    private String nombres;
    @DatabaseField
    private char sexo; // 'F' o 'M'
    @DatabaseField(columnName="lugar_nacimiento")
    private String lugarNacimiento; // Cusco, Lima, Tacna

    public Persona() {
        this.dni = 0;
        this.nombres = "";
        this.sexo = '\u0000';
        this.lugarNacimiento = "";        
    }

    public Persona(int dni, String nombres, char sexo, String lugarNacimiento) {
        this.dni = dni;
        this.nombres = nombres;
        this.sexo = sexo;
        this.lugarNacimiento = lugarNacimiento;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }    

    @Override
    public String toString() {
        return nombres;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (this.dni != other.dni) {
            return false;
        }
        return true;
    }
}

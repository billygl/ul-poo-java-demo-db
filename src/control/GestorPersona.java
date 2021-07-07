package control;

import dao.LugarDao;
import dao.PersonaDao;
import java.util.List;
import modelo.*;

public class GestorPersona {

    private Persona[] arr; // Arreglo de personas
    private final static int MAX = 100;
    private int n; // Cantidad de personas registradas en el arreglo

    public GestorPersona() {
        refrescar();
    }

    // Operaciones
    // Longitud: Cantidad de personas en el arreglo

    public int longitud() {
        return n;
    }

    // Agregar una persona al Arreglo

    public void agregar(Persona persona) {        
        PersonaDao personaDao = new PersonaDao();
        Persona personaActualizar = personaDao.obtener(persona.getDni());
        if(personaActualizar == null){
            personaDao.crear(persona);
        }else{
            personaDao.actualizar(persona);
        }
    }

    public void eliminar(int dni) {
        PersonaDao personaDao = new PersonaDao();
        Persona persona = personaDao.obtener(dni);
        if(persona != null){
            personaDao.eliminar(persona);
        }
    }

    // Buscar una persona

    public int posicion(int dni) {
        for (int i = 0; i < n; i++) {
            if (arr[i].getDni() == dni) {
                return i;
            }
        }
        return -1;
    }

    public Persona iesimo(int pos) {
        if (pos >= 0 && pos < n) {
            return arr[pos];
        }
        return null;
    }

    public String mostrar() {
        String cadena = "";
        PersonaDao personaDao = new PersonaDao();
        List<Persona> lista = personaDao.listar();
        int n = lista.size();
        for (int i = 0; i < n; i++) {
            cadena = cadena + lista.get(i).getNombres() + "\n";
        }
        return cadena;
    }

    public void ordenarPorNombres() {
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                if (arr[j].getNombres().compareTo(arr[j - 1].getNombres()) < 0) {
                    // Intercambiar
                    Persona aux = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = aux;
                }
            }
        }
    }

    public void ordenarPorCiudad() {
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                if (arr[j].getLugarNacimiento().getNombre().
                    compareTo(arr[j - 1].getLugarNacimiento().getNombre()) 
                    < 0) {
                    // Intercambiar
                    Persona aux = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = aux;
                }
            }
        }
    }
    
    public void refrescar(){
        PersonaDao personaDao = new PersonaDao();
        List<Persona> lista = personaDao.listar();

        arr = new Persona[lista.size()];        
        arr = lista.toArray(arr);
        n = arr.length;
    }
    
    public List<Lugar> obtenerLugares(){
        LugarDao lugarDao = new LugarDao();
        return lugarDao.listar();
    }
}

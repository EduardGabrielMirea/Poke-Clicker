package poke.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String pass;

    /**
     * Constructor completo.
     *
     * @param id    Identificador único de la entidad.
     * @param nombre Nombre de usuario.
     * @param pass   Contraseña del usuario.
     */

    public Usuario(Long id, String nombre, String pass) {
        this.id = id;
        this.nombre = nombre;
        this.pass = pass;
    }

    /**
     * Constructor sin ID, utilizado al crear nuevas instancias antes de persistir.
     *
     * @param nombre Nombre de usuario.
     * @param pass   Contraseña del usuario.
     */

    public Usuario(String nombre, String pass) {
        this.nombre = nombre;
        this.pass = pass;
    }

    /**
     * Constructor por defecto.
     */

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return String.format("Usuario [id=%s, nombre=%s, pass=%s]", id, nombre, pass);
    }
}

package poke.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Login {
    @Id
    //AUTO no funciona bien con SQLite porque intenta obtener el valor de una tabla de secuencias para cada tabla
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String pass;

}

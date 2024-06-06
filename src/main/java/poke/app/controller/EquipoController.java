package poke.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import poke.app.entity.Equipo;
import poke.app.entity.Login;
import poke.app.entity.Pokemon;
import poke.app.repository.EquipoRepository;
import poke.app.repository.LoginRepository;

import poke.app.service.PokemonService;

import java.util.ArrayList;
import java.util.List;

@Component
public class EquipoController{
    private final EquipoRepository equipoRepository;

    @Autowired
    public EquipoController(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;

    }

    public Equipo getEquipo(Long id_user) {
           return this.equipoRepository.findEquipoById(id_user);
    }
}

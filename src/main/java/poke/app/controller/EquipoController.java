package poke.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import poke.app.entity.Equipo;
import poke.app.entity.Pokemon;
import poke.app.repository.EquipoRepository;
import poke.app.service.AppService;

import java.util.ArrayList;
import java.util.List;

@Component
public class EquipoController{
    private final EquipoRepository equipoRepository;
    private final AppService appService;

    @Autowired
    public EquipoController(EquipoRepository equipoRepository,AppService appService) {
        this.equipoRepository = equipoRepository;
        this.appService = appService;
    }
}

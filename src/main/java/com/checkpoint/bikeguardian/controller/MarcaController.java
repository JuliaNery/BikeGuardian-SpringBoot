package com.checkpoint.bikeguardian.controller;

import com.checkpoint.bikeguardian.entities.bicicleta.MarcaEntity;
import com.checkpoint.bikeguardian.repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/marcas")
public class MarcaController {
    @Autowired
    private MarcaRepository marcaRepository;

    @GetMapping
    public List<MarcaEntity> listar{

    }

}

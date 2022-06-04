package com.prueba.prueba.controllers;

import com.prueba.prueba.dao.BancoDao;
import com.prueba.prueba.models.Banco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BancoController {

    @Autowired
    private BancoDao bancoDao;

    @RequestMapping("/bancos")
    public List<Banco> getBancos() {
        return bancoDao.getBancos();
    }

    @RequestMapping(value = "bancos/pagar/{id}")
    public void Pagar(@PathVariable(value = "id") int id){
        bancoDao.Pagar(id);
    }

}

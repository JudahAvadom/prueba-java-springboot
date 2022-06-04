package com.prueba.prueba.dao;

import com.prueba.prueba.models.Banco;

import java.util.List;

public interface BancoDao {

    List<Banco> getBancos();

    void Pagar(int Nvoid);

}
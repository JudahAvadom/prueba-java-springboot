package com.prueba.prueba.dao;

import com.prueba.prueba.models.Banco;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class BancoDaoImp implements BancoDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Banco> getBancos() {
        String query = "FROM bancos";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void Pagar(int Nvoid){
        entityManager.createQuery("UPDATE bancos SET pagado = 1 WHERE id = " + Nvoid).executeUpdate();
    }
}
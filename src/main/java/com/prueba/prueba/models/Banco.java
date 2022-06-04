package com.prueba.prueba.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity(name = "bancos")
@Table(name = "bancos")
@ToString @EqualsAndHashCode
public class Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private int id;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    @Getter @Setter @Column(name = "deuda")
    private int deuda;

    @Getter @Setter @Column(name = "pagado")
    private boolean pagado;

}

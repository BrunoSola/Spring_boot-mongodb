package com.brunosola.springBootMongo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

// Utiliza-se lombok para reduzir a verbosidade do código, evitando a necessidade de escrever os métodos repetitivos.
@Data // Gera automaticamente os metodos getter, setters, toString, equals, hashCode
@NoArgsConstructor // construtor sem argumentos
@AllArgsConstructor // construtor com todos argumentos
public class User implements Serializable {
    private String id;
    private String name;
    private String email;
}

package com.exercicio.collections;

import java.util.*;

public class MapExercise {

    public static void exercise1(){
        Map<String, Integer> populacaoNordeste = new HashMap<>(){{
            put("PE",9616621);
            put("AL",3351543);
            put("CE",9187103);
            put("RN",3534265);
        }};

        System.out.println("--- Populações dos Estados do Nordeste ---");
        populacaoNordeste.forEach((estado, populacao) -> {
                System.out.println("Estado: " + estado + "; População: " + populacao);
        });

        System.out.println("--- Populações c/ Paraíba ---");
        populacaoNordeste.putIfAbsent("PB", 4039277);

        populacaoNordeste.forEach((estado, populacao) -> {
            System.out.println("Estado: " + estado + "; População: " + populacao);
        });

        System.out.println("--- População de PE ---");
        System.out.println("População de PE: " + populacaoNordeste.get("PE"));

    }
}

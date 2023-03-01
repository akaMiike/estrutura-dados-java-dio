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

    public static void exercise2(){

        System.out.println("--- Populações c/ ordem de inserção ---");
        Map<String, Integer> populacoesOrdemInsercao = new LinkedHashMap<>(){{
            put("PE",9616621);
            put("AL",3351543);
            put("CE",9187103);
            put("RN",3534265);
            put("PB", 4039277);
        }};

        populacoesOrdemInsercao.forEach((estado, populacao) -> {
            System.out.println("Estado: " + estado + "; População: " + populacao);
        });

        System.out.println("--- Estados em ordem alfabética e suas populações ---");
        Map<String, Integer> estadosOrdemAlfabetica = new TreeMap<>(populacoesOrdemInsercao);
        estadosOrdemAlfabetica.forEach((estado, populacao) -> {
            System.out.println("Estado: " + estado + "; População: " + populacao);
        });


        System.out.println("--- Estado com menor população ---");
        Integer menorPopulacao = Collections.min(estadosOrdemAlfabetica.values());
        Set<Map.Entry<String,Integer>> entradas = estadosOrdemAlfabetica.entrySet();
        for(Map.Entry<String, Integer> entrada : entradas){
            if(entrada.getValue().equals(menorPopulacao))
                System.out.println("Estado: " + entrada.getKey() + "; População: " + entrada.getValue());
        }

        System.out.println("--- Estado com maior população ---");
        Integer maiorPopulacao = Collections.max(estadosOrdemAlfabetica.values());
        entradas = estadosOrdemAlfabetica.entrySet();
        for(Map.Entry<String, Integer> entrada : entradas){
            if(entrada.getValue().equals(maiorPopulacao))
                System.out.println("Estado: " + entrada.getKey() + "; População: " + entrada.getValue());
        }

        System.out.println("--- Soma das populações ---");
        Integer somaPopulacao = estadosOrdemAlfabetica.values().stream()
                .reduce(0, (a,b) -> a += b);
        System.out.println("Total população: " + somaPopulacao);

        System.out.println("--- Media das populações ---");
        System.out.println("Média: " + somaPopulacao/estadosOrdemAlfabetica.size());

        System.out.println("--- Estados com populações maior que 4 milhões ---");
        estadosOrdemAlfabetica.values().removeIf(value -> value < 4000000);
        estadosOrdemAlfabetica.forEach((estado, populacao) -> {
            System.out.println("Estado: " + estado + "; População: " + populacao);
        });

        estadosOrdemAlfabetica.clear();
        System.out.println("Map está vazio após clear()? " + estadosOrdemAlfabetica.isEmpty());

    }

}

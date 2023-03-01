package com.exercicio.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExercise {

    public static void exercise1(){
        List<String> numerosAleatorios = List.of("1", "3", "4", "1", "6", "8", "9", "0", "2", "2", "9", "15", "30");

        System.out.println("----- Numeros aleatórios ----");
        System.out.println(numerosAleatorios);

        System.out.println("----- Numeros aleatórios excetos os três primeiros ----");
        numerosAleatorios.stream()
                .skip(3)
                .map(Integer::parseInt)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("----- Numeros aleatórios excetos os repetidos ----");
        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("----- Menor número ----");
        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .min(Integer::compare)
                .ifPresent(System.out::println);

        System.out.println("----- Maior número ----");
        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .max(Integer::compare)
                .ifPresent(System.out::println);

        System.out.println("----- Soma numeros ímpares ----");
        Integer somaNumerosImpares = numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .reduce(0, (a,b) -> a += b);

        System.out.println(somaNumerosImpares);

        System.out.println("----- Numeros ordenados de forma crescente ----");
        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .sorted(Integer::compare)
                .forEach(System.out::println);

        System.out.println("----- Numeros multiplos de 3 e 5 agrupados ----");
        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(
                        Collectors.groupingBy(
                                n -> n % 5 == 0 && n % 3 == 0
                        )
                )
                .forEach((key, value) -> System.out.println("Multiplo de 3 e 5?: " + key + "; Numeros: " + value));

    }
}

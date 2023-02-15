package com.exercicio.collections;

import java.util.*;

public class ListExercise {

    private static class Temperature{
        public double avgTemp;
        public String month;

        public Temperature(double temp, String month){
            this.avgTemp = temp;
            this.month = month;
        }

        @Override
        public String toString() {
            return "Temperature{" +
                    "avgTemp=" + avgTemp +
                    ", month='" + month + '\'' +
                    '}';
        }
    }

    public static void exercise1(){
        System.out.print("Digite a temperatura média dos 6 primeiros meses: ");
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double avgSemestralTemp = 0d;

        List<Temperature> temperatures = new ArrayList<>(List.of(
                new Temperature(scanner.nextDouble(), "Janeiro"),
                new Temperature(scanner.nextDouble(), "Fevereiro"),
                new Temperature(scanner.nextDouble(), "Março"),
                new Temperature(scanner.nextDouble(), "Abril"),
                new Temperature(scanner.nextDouble(), "Maio"),
                new Temperature(scanner.nextDouble(), "Junho")
        ));

        for(Temperature temp: temperatures)
            avgSemestralTemp += temp.avgTemp;

        avgSemestralTemp = avgSemestralTemp/temperatures.size();

        Iterator<Temperature> iterator = temperatures.listIterator();
        while(iterator.hasNext()){
            Temperature value = iterator.next();
            if(value.avgTemp < avgSemestralTemp) iterator.remove();
        }

        System.out.println("\nOs seguintes meses tem a temperatura maior que a temperatura média do semestre: ");
        System.out.println(temperatures);
    }

    public static void exercise2(){
        List<String> answers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int numPositiveAnswers = 0;

        System.out.println("Responda as seguintes perguntas com 'Sim' ou 'Nao': ");

        System.out.println("Pergunta 1 - Telefonou para a vítima?");
        answers.add(scanner.next());
        System.out.println("Pergunta 2 - Esteve no local do crime?");
        answers.add(scanner.next());
        System.out.println("Pergunta 3 - Mora perto da vítima?");
        answers.add(scanner.next());
        System.out.println("Pergunta 4 - Devia algo para a vítima?");
        answers.add(scanner.next());
        System.out.println("Pergunta 5 - Já trabalhou com a vítima?");
        answers.add(scanner.next());

        for(String answer: answers)
            if(answer.equalsIgnoreCase("Sim")) numPositiveAnswers++;

        if(numPositiveAnswers == 2)
            System.out.println("Você foi declarado(a) como suspeito!");
        else if(numPositiveAnswers >= 3 && numPositiveAnswers <= 4)
            System.out.println("Você foi declarado(a) como cúmplice!");
        else if(numPositiveAnswers == 5)
            System.out.println("Você foi declarado(a) como assassino(a)!");
        else
            System.out.println("Você foi declarado(a) como inocente!");
    }
}

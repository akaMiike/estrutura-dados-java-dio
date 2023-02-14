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
}

package com.exercicio.collections;


import java.util.*;

public class SetExercise {
    public static void exercise1(){
        Set<String> coresArcoIris = new HashSet<>();
        coresArcoIris.addAll(List.of(
                "Vermelho",
                "Verde",
                "Laranja",
                "Amarelo",
                "Azul",
                "Azul escuro",
                "Violeta"
        ));

        System.out.println("---- Cores do arco-íris ----");
        for(String cor: coresArcoIris){
            System.out.println(cor);
        }

        System.out.println("---- Qtd. cores do arco-íris ----");
        System.out.println(coresArcoIris.size());

        Set<String> coresOrdenadas = new TreeSet<>(coresArcoIris);

        System.out.println("---- Cores do arco-íris ordenadas ----");
        for(String cor: coresOrdenadas){
            System.out.println(cor);
        }

        List<String> coresOrdenadasList = new ArrayList<>(coresOrdenadas);
        Collections.reverse(coresOrdenadasList);

        System.out.println("---- Cores do arco-íris ordenadas (reverso) ----");
        for(String cor: coresOrdenadasList){
            System.out.println(cor);
        }


        System.out.println("---- Cores do arco-íris que começam com 'v' ----");
        for (String corAtual : coresArcoIris) {
            if (corAtual.toLowerCase().startsWith("v")) System.out.println(corAtual);
        }

        coresArcoIris.removeIf(corAtual -> corAtual.toLowerCase().startsWith("v"));

        System.out.println("---- Cores do arco-íris exceto as que começam com 'v' ----");
        for(String cor: coresArcoIris){
            System.out.println(cor);
        }

        coresArcoIris.clear();
        System.out.println("Set está vazio após clear()? " + coresArcoIris.isEmpty());



    }

    public static void exercise2(){
        Set<LinguagemFavorita> linguagensFavoritas = new HashSet<>(List.of(
                new LinguagemFavorita("Python", 1991, "VSCode"),
                new LinguagemFavorita("Typescript", 2012, "VSCode"),
                new LinguagemFavorita("Java", 1991, "Intellij")
        ));

        System.out.println("--- Linguagens favoritas por ordem de inserção ---");
        Set<LinguagemFavorita> linguagemFavoritasOrdemInsercao = new LinkedHashSet<>(linguagensFavoritas);
        for(LinguagemFavorita linguagem: linguagemFavoritasOrdemInsercao ){
            System.out.println(linguagem);
        }

        Set<LinguagemFavorita> linguagemFavoritasOrdemNome = new TreeSet<>(new ComparatorLinguagemFavoritaPorNome());

        System.out.println("--- Linguagens favoritas por ordem de nome ---");
        linguagemFavoritasOrdemNome.addAll(linguagensFavoritas);
        for(LinguagemFavorita linguagem: linguagemFavoritasOrdemNome ){
            System.out.println(linguagem);
        }

        Set<LinguagemFavorita> linguagemFavoritasOrdemIDE = new TreeSet<>(new ComparatorLinguagemFavoritaPorIDE());

        System.out.println("--- Linguagens favoritas por ordem de IDE ---");
        linguagemFavoritasOrdemIDE.addAll(linguagensFavoritas);
        for(LinguagemFavorita linguagem: linguagemFavoritasOrdemIDE ){
            System.out.println(linguagem);
        }

        Set<LinguagemFavorita> linguagemFavoritasOrdemAnoCriacaoENome = new TreeSet<>(new ComparatorLinguagemFavoritaPorAnoCriacaoENome());

        System.out.println("--- Linguagens favoritas por ordem de Ano de criação e Nome ---");
        linguagemFavoritasOrdemAnoCriacaoENome.addAll(linguagensFavoritas);
        for(LinguagemFavorita linguagem: linguagemFavoritasOrdemAnoCriacaoENome ){
            System.out.println(linguagem);
        }

        Set<LinguagemFavorita> linguagemFavoritasOrdemAnoCriacaoENomeEIDE = new TreeSet<>(new ComparatorLinguagemFavoritaPorNomeEAnoCriacaoEIDE());

        System.out.println("--- Linguagens favoritas por ordem de Nome, ano de criação e IDE ---");
        linguagemFavoritasOrdemAnoCriacaoENomeEIDE.addAll(linguagensFavoritas);
        for(LinguagemFavorita linguagem: linguagemFavoritasOrdemAnoCriacaoENomeEIDE ){
            System.out.println(linguagem);
        }

    }

    private static class LinguagemFavorita{
        String nome;
        Integer anoDeCriacao;
        String ide;

        public LinguagemFavorita(String nome, Integer anoDeCriacao, String ide) {
            this.nome = nome;
            this.anoDeCriacao = anoDeCriacao;
            this.ide = ide;
        }

        @Override
        public String toString() {
            return "LinguagemFavorita{" +
                    "nome='" + nome + '\'' +
                    ", anoDeCriacao=" + anoDeCriacao +
                    ", ide='" + ide + '\'' +
                    '}';
        }
    }

    private static class ComparatorLinguagemFavoritaPorNome implements Comparator<LinguagemFavorita>{

        @Override
        public int compare(LinguagemFavorita linguagemFavorita, LinguagemFavorita t1) {
            return linguagemFavorita.nome.compareTo(t1.nome);
        }
    }

    private static class ComparatorLinguagemFavoritaPorIDE implements Comparator<LinguagemFavorita>{

        @Override
        public int compare(LinguagemFavorita linguagemFavorita, LinguagemFavorita t1) {
            return linguagemFavorita.ide.compareToIgnoreCase(t1.ide);
        }
    }

    private static class ComparatorLinguagemFavoritaPorAnoCriacaoENome implements Comparator<LinguagemFavorita>{

        @Override
        public int compare(LinguagemFavorita linguagemFavorita, LinguagemFavorita t1) {
            int comparacaoAnoCriacao = linguagemFavorita.anoDeCriacao.compareTo(t1.anoDeCriacao);
            if(comparacaoAnoCriacao != 0) return comparacaoAnoCriacao;

            return linguagemFavorita.nome.compareToIgnoreCase(t1.nome);
        }
    }

    private static class ComparatorLinguagemFavoritaPorNomeEAnoCriacaoEIDE implements Comparator<LinguagemFavorita>{

        @Override
        public int compare(LinguagemFavorita linguagemFavorita, LinguagemFavorita t1) {
            int comparacaoNome = linguagemFavorita.nome.compareToIgnoreCase(t1.nome);
            if(comparacaoNome != 0) return comparacaoNome;

            int comparacaoAnoCriacao = linguagemFavorita.anoDeCriacao.compareTo(t1.anoDeCriacao);
            if(comparacaoAnoCriacao != 0) return comparacaoAnoCriacao;

            return linguagemFavorita.ide.compareToIgnoreCase(t1.ide);
        }
    }

}

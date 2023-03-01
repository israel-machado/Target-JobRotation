package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

import Utility.FaturamentoMensal;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // Lendo o arquivo JSON
        byte[] jsonData = Files.readAllBytes(new File("src/main/java/org/example/dados.json").toPath());

        // Desserializando o JSON em um objeto Java
        FaturamentoMensal faturamentoMensal = mapper.readValue(jsonData, FaturamentoMensal.class);

        // Obtendo o menor valor de faturamento
        double menorFaturamento = Arrays.stream(faturamentoMensal.faturamentoDiario)
                .filter(f -> f.valor > 0)
                .mapToDouble(f -> f.valor)
                .min()
                .orElse(0);

        // Obtendo o maior valor de faturamento
        double maiorFaturamento = Arrays.stream(faturamentoMensal.faturamentoDiario)
                .filter(f -> f.valor > 0)
                .mapToDouble(f -> f.valor)
                .max()
                .orElse(0);

        // Calculando a média mensal de faturamento
        double mediaMensal = Arrays.stream(faturamentoMensal.faturamentoDiario)
                .filter(f -> f.valor > 0)
                .mapToDouble(f -> f.valor)
                .average()
                .orElse(0);

        // Obtendo o número de dias em que o valor de faturamento diário foi superior à média mensal
        long diasAcimaDaMedia = Arrays.stream(faturamentoMensal.faturamentoDiario)
                .filter(f -> f.valor > mediaMensal)
                .count();

        System.out.println("Menor faturamento: " + String.format("%.2f", menorFaturamento));
        System.out.println("Maior faturamento: " + String.format("%.2f", maiorFaturamento));
        System.out.println("Média mensal: " + String.format("%.2f", mediaMensal));
        System.out.println("Dias com faturamento acima da média: " + diasAcimaDaMedia);
    }
}
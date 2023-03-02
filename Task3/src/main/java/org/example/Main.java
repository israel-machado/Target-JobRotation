package org.example;

import Utility.Faturamento;
import Utility.FaturamentoMensal;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            FaturamentoMensal faturamentoMensal = mapper.readValue(new File("src/main/java/org/example/dados.json"), FaturamentoMensal.class);

            List<Faturamento> diasFaturamento = faturamentoMensal.getFaturamentoDiario()
                    .stream()
                    .filter(f -> f.getValor() > 0)
                    .collect(Collectors.toList());

            double menorFaturamento = diasFaturamento
                    .stream()
                    .mapToDouble(Faturamento::getValor)
                    .min()
                    .orElse(0);

            double maiorFaturamento = diasFaturamento
                    .stream()
                    .mapToDouble(Faturamento::getValor)
                    .max()
                    .orElse(0);

            double mediaMensal = diasFaturamento
                    .stream()
                    .mapToDouble(Faturamento::getValor)
                    .average()
                    .orElse(0);

            int diasAcimaMedia = contarDiasAcimaMedia(diasFaturamento, mediaMensal);

            System.out.println("Menor faturamento: " + String.format("%.2f", menorFaturamento));
            System.out.println("Maior faturamento: " +  String.format("%.2f", maiorFaturamento));
            System.out.println("Média mensal de faturamento: " +  String.format("%.2f", mediaMensal));
            System.out.println("Número de dias acima da média: " + diasAcimaMedia);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int contarDiasAcimaMedia(List<Faturamento> diasFaturamento, double mediaMensal) {
        return (int) diasFaturamento.stream().filter(dia -> dia.getValor() > mediaMensal).count();
    }
}




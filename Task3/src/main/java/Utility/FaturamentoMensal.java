package Utility;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FaturamentoMensal {
    private List<Faturamento> faturamentoDiario;

    @JsonProperty("faturamentoDiario")
    public List<Faturamento> getFaturamentoDiario() {
        return faturamentoDiario;
    }

    public void setFaturamentoDiario(List<Faturamento> faturamentoDiario) {
        this.faturamentoDiario = faturamentoDiario;
    }
}


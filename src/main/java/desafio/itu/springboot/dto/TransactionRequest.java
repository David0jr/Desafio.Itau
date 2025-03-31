package desafio.itu.springboot.dto;


import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public class TransactionRequest {

    @NotNull//nao recebe valores nulos
    private double valor;

    @NotNull
    private OffsetDateTime dataHora;


    public double getValor() {
        return valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }
}

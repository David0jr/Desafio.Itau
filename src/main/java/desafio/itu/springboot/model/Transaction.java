package desafio.itu.springboot.model;

import java.time.OffsetDateTime;

public class Transaction {

    private double valor;
    private OffsetDateTime dataHora;

    //O "final" protege o parâmetro nome, impedindo alterações dentro do método.
    //O atributo this.nome pode ser inicializado, mas não pode ser modificado depois.
    public Transaction(final double valor, final OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }

    //Para um melhor encapsulamento, apenas os gets, pois os atributos foram passados no construtor.
    public double getValor() {
        return valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }
}

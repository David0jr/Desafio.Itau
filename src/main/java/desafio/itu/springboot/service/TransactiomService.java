package desafio.itu.springboot.service;

import desafio.itu.springboot.model.Transaction;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class TransactiomService {

    //Nesta aplicação, tenho que trabalhar na memoria.
    // É uma fila de objetos Transaction, seguindo a interface
    private final Queue<Transaction> transactions = new ConcurrentLinkedQueue<>();

    public void addTransaction (Transaction transaction){
        transactions.add(transaction);
    }

    public void clearTransaction(){
        transactions.clear();
    }

    //Este método retorna estatísticas sobre transações financeiras realizadas nos últimos 60 segundos.
    public DoubleSummaryStatistics getStatistic (){
        OffsetDateTime now = OffsetDateTime.now();//Pega a data e hora exata do momento da execução.
        return transactions.stream()//Percorre todas as transações armazenadas.
                .filter(t -> t.getDataHora().isAfter(now.minusSeconds(60)))//Filtra transações feitas nos últimos 60 segundos
                .mapToDouble(Transaction::getValor)//Converte cada transação (Transaction) no seu valor (double).
                .summaryStatistics();//Gera estatísticas com base nos valores obtidos.
    }
}

package desafio.itu.springboot.dto;

import java.util.DoubleSummaryStatistics;

public class StatisticResponse {

    private long count; //O "long" armazena um número inteiro grande (até 9 quintilhões, pois long tem 64 bits).
    private double sum;
    private double avg;
    private double min;
    private double max;

    //DoubleSummaryStatistics é uma classe do Java (java.util) que calcula estatísticas sobre números do tipo double
    public StatisticResponse(DoubleSummaryStatistics stats) {

        this.count = stats.getCount();
        this.sum = stats.getSum();
        this.avg = stats.getAverage();
        this.min = stats.getMin();
        this.max = stats.getMax();
    }

    public long getCount() {
        return count;
    }

    public double getSum() {
        return sum;
    }

    public double getAvg() {
        return avg;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }
}

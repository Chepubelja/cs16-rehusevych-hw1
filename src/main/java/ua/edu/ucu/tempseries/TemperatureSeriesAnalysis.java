package ua.edu.ucu.tempseries;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    private double[] temperatureSeries;
    private int sum;

    public TemperatureSeriesAnalysis() {

    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.temperatureSeries = temperatureSeries;
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] < -273) {
                throw new InputMismatchException();
            }
        }
    }

    public double average() {
        double counter = 0;

        if (temperatureSeries.equals(0))
            throw new IllegalArgumentException();
        for (int i = 0; i < temperatureSeries.length; i++) {
            counter += temperatureSeries[i];
        }
        double average = counter / temperatureSeries.length;
        return average;
    }

    public double deviation() {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double our_sum = 0;
        for (int i = 0; i < temperatureSeries.length; i++) {
            double k = Math.pow(temperatureSeries[i] - average(), 2);
            our_sum += k;
        }
        double l = Math.sqrt((our_sum / temperatureSeries.length));

        return l;
    }

    public double min() {
        int len = temperatureSeries.length;
        if (len == 0) {
            throw new IllegalArgumentException();
        }
        double minimum = temperatureSeries[0];
        for (int i = 1; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] < minimum) {
                minimum = temperatureSeries[i];
            }
        }
        return minimum;
    }

    public double max() {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double maximum = temperatureSeries[0];
        for (int i = 1; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] > maximum) {
                maximum = temperatureSeries[i];
            }
        }
        return maximum;
    }

    public double findTempClosestToZero() {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double closest = temperatureSeries[0];
        for (int i = 1; i < temperatureSeries.length; i++) {
            if (Math.abs(temperatureSeries[i]) < closest) {
                closest = temperatureSeries[i];
            } else if (Math.abs(temperatureSeries[i]) == Math.abs(closest) && temperatureSeries[i] > 0) {
                closest = temperatureSeries[i];
            }
        }
        return closest;
    }

    public double findTempClosestToValue(double tempValue) {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        int counter = 0;
        double difference = 0;
        double closest = Math.abs(temperatureSeries[0] - tempValue);
        for (int i = 1; i < temperatureSeries.length; i++) {
            if (Math.abs(temperatureSeries[i] - tempValue) < closest) {
                closest = temperatureSeries[i];
                counter += 1;
            }
        }
        difference = temperatureSeries[counter];
        return difference;
    }

    public double[] findTempsLessThen(double tempValue) {
        int size = 0;
        int counter = 0;
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] < tempValue) {
                size += 1;
            }
        }

        double[] lst1 = new double[size];
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] < tempValue) {
                lst1[counter] = temperatureSeries[i];
                counter += 1;
            }
        }
        return lst1;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        int size = 0;
        int counter = 0;
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] > tempValue) {
                size += 1;
            }
        }
        double[] lst1 = new double[size];
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] > tempValue) {
                lst1[counter] = temperatureSeries[i];
                counter += 1;
            }
        }
        return lst1;
    }

    public TempSummaryStatistics summaryStatistics() {

        if (temperatureSeries.length == 0){
            throw new IllegalArgumentException();
        }
        TempSummaryStatistics a = new TempSummaryStatistics(this.average(), this.deviation(), this.min(), this.max());
        return a;
    }

    public int addTemps(double... temps) {
//        double[] newTempSeries = new double[Math.max(this.temperatureSeries.length+temps.length, this.temperatureSeries.length * 2)];
//        for (int i = 0; i < temps.length; i++) {
//        newTempSeries[i] = temps[i];}
//        for (int i = 0; i < this.temperatureSeries.length; i++){
//            newTempSeries[i+temps.length] = this.temperatureSeries[i];
//        }
//        this.temperatureSeries = newTempSeries;
//        this.sum = this.sum + temps.length;
//        return this.sum;
        int counter = 0;
        double[] new_lst = new double[Math.max(temperatureSeries.length + temps.length, this.temperatureSeries.length * 2)];
        for (int i = 0; i < temperatureSeries.length; i++) {
            new_lst[i] = temperatureSeries[i];
        }
        for (int j = 0; j < temps.length; j++) {
            new_lst[j + temperatureSeries.length] = temps[j];
        }
        int len = temperatureSeries.length + temps.length;
        return len;
        }
    }


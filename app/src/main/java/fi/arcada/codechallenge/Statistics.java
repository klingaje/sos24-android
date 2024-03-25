package fi.arcada.codechallenge;

public class Statistics {

    public static double calcMean(double[] values) {
        double summa = 0;
        for (int i = 0; i < values.length; i++) {
            summa = summa + values[i];
        }

        return summa / values.length;
    }
}

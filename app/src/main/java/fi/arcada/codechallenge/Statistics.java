package fi.arcada.codechallenge;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class Statistics {

    public static double calcMean(ArrayList<Double> values) {
        double summa = 0;
        // arraylist har .size() istället för length
        for (int i = 0; i < values.size(); i++) {
            summa = summa + values.get(i);
        }

        return summa / values.size();
    }

    public static double calcMedian(ArrayList<Double> values) {
        // vi skapar en kopia av values
        ArrayList<Double> sorted = new ArrayList<>(values);
        // sedan sorterar vi kopian. Annars sorteras ursprungliga datamängden
        Collections.sort(sorted);

        // detta funkar, ännu bättre skulle vara att kolla skillt för jämna datamängder
        int midIndex = sorted.size() / 2;

        //median är det mittersta värdet i vår sorterade datamängd!
        return sorted.get(midIndex);

    }

    public static double calcStdev(ArrayList<Double> values) {
        double skillnad = 0;
        for (int i = 0; i < values.size(); i++) {
            skillnad = skillnad + Math.pow(values.get(i) - calcMean(values), 2);


        }
        double varians = skillnad / values.size();

        return Math.sqrt(varians);
    }


    public static double calcMode(ArrayList<Double> values) {
        HashMap<Double, Integer> valueCount = new HashMap<>();

        for (double dataValue: values) {
            Integer count = valueCount.get(dataValue);

            if (count == null) count = 0;

            valueCount.put(dataValue, count+1);
        }


            int maxCount = 0;
            double modeValue = 0.0;

            for (Double dataValue: valueCount.keySet()) {
                Integer curCount = valueCount.get(dataValue);

                if (curCount > maxCount) {
                    maxCount = curCount;
                    modeValue = dataValue;
                }
            }
            return modeValue;
    }


    public static double calcLQ (ArrayList<Double> values) {
        ArrayList<Double> sorted = new ArrayList<>(values);

        Collections.sort(sorted);

        if (sorted.size() % 2 == 0) {
            return 0;
        }

            int lowQ = (int) (sorted.size() * 0.25);
            return sorted.get(lowQ);
    }

    public static double calcHQ (ArrayList<Double> values) {
        ArrayList<Double> sorted = new ArrayList<>(values);

        Collections.sort(sorted);

        int highQ = (int) (sorted.size() * 0.75);
        return sorted.get(highQ);
    }

    public static double calcIQR (ArrayList<Double> values) {
        ArrayList<Double> sorted = new ArrayList<>(values);

        Collections.sort(sorted);

        int IQR = (int) (sorted.size() * 0.75) - (int) (sorted.size() * 0.25);
        return sorted.get(IQR);
    }

}
package fi.arcada.codechallenge;

import java.util.ArrayList;
import java.util.Collections;

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
        int midIndex = sorted.size()/2;

        //median är det mittersta värdet i vår sorterade datamängd!
        return sorted.get(midIndex);

    }

    public static double calcStdev(ArrayList<Double> values) {
        double skillnad = 0;
        for (int i = 0; i < values.size(); i++) {
            skillnad = skillnad + Math.pow(values.get(i) - calcMean(values), 2);
        }

        double varians = skillnad/values.size();

        return Math.sqrt(varians);
    }

}

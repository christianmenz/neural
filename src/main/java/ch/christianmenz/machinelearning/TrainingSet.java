package ch.christianmenz.machinelearning;

import java.util.LinkedList;

/**
 *
 * @author Christian
 */
public class TrainingSet {

    private LinkedList<TrainingRow> trainingRows = new LinkedList<>();

    public TrainingSet() {
    }

    public void addRow(TrainingRow trainingRow) {
        trainingRows.add(trainingRow);
    }

}

package ch.christianmenz.machinelearning;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Christian
 */
public class TrainingSet {

    private List<TrainingRow> trainingRows = new LinkedList<>();

    public TrainingSet() {
    }

    public void addRow(TrainingRow trainingRow) {
        trainingRows.add(trainingRow);
    }

    public List<TrainingRow> getTrainingRows() {
        return trainingRows;
    }       

}

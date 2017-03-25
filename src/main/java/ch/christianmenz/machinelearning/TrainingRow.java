package ch.christianmenz.machinelearning;

/**
 *
 * @author Christian
 */
public class TrainingRow {

    private final double[] input;

    private final double[] output;

    TrainingRow(double[] input, double[] output) {       
        this.input = input;
        this.output = output;
    }
    
}

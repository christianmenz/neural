package ch.christianmenz.machinelearning;

/**
 *
 * @author Christian
 */
public class Trainer {

    private final NeuralNetwork net;

    private final TrainingSet trainingSet;
    private final double learningRate;
    private double currentError = Double.MAX_VALUE;

    public Trainer(NeuralNetwork net, TrainingSet trainingSet, double learningRate) {
        this.net = net;
        this.trainingSet = trainingSet;
        this.learningRate = learningRate;
    }

    public void train() {
        // 
    }

    public double getCurrentError() {
        return currentError;
    }

}

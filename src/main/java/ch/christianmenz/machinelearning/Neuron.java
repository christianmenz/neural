package ch.christianmenz.machinelearning;

/**
 *
 * @author Christian
 */
public class Neuron {

    private double bias;

    private double weight;

    private double input;

    private double output;

    private NeuralNetwork network;

    private double[] inputWeights;

    private int layer; // in which layer am I?

    public Neuron(NeuralNetwork network, int layer) {
        this.network = network;
        this.layer = layer;

        if (layer != 0) {
            this.inputWeights = new double[network.getNeurons()[layer - 1].length];
        }
        
    }

    public double activate(double input) {
        return 0d;
    }
    
}

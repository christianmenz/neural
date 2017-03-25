package ch.christianmenz.machinelearning;

import java.util.Arrays;

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
        this.bias = Math.random(); // just assume its never 0? or add some real small number ..or add a check?        

        if (layer != 0) {
            this.inputWeights = new double[network.getNeurons()[layer - 1].length];
            for (int i = 0; i < inputWeights.length; i++) {
                inputWeights[i] = Math.random();
            }
        }
    }

    public void activate() {
        double[] inputs = null;
        Neuron[] neurons = network.getNeurons()[layer - 1];

        if (layer == 1) {
            inputs = network.getInput();
        } else {
            inputs = new double[neurons.length]; // TODO: reuse array..
            for (int i = 0; i < neurons.length; i++) {
                inputs[i] = neurons[i].getOutput();
            };
        }

        // sum up weights*inputs
        double sum = 0;
        for (int i = 0; i < inputs.length; i++) {
            sum += inputs[i] * neurons[i].weight + bias;
        }

        // transfer function (sigmoid)
        if (sum > 100) {
            output = 1.0d;
        } else if (sum < -100) {
            output = 0.0d;
        } else {
            output = (1d / (1d + Math.exp(sum)));
        }

    }

    public double getOutput() {
        return output;
    }

}

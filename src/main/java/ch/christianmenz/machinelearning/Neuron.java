package ch.christianmenz.machinelearning;

/**
 *
 * @author Christian
 */
public class Neuron {

    private double bias;

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
        Neuron[] inputConnections = network.getNeurons()[layer - 1];

        inputs = new double[inputConnections.length]; // TODO: reuse array..
        for (int i = 0; i < inputConnections.length; i++) {
            inputs[i] = inputConnections[i].getOutput();
        };

        // sum up weights*inputs
        double sum = 0;
        for (int i = 0; i < inputs.length; i++) {
            sum += inputs[i] * inputWeights[i];
        }
        sum += bias;

        // transfer function (sigmoid)
        if (sum > 100) {
            output = 1.0d;
        } else if (sum < -100) {
            output = 0.0d;
        } else {
            output = (1d / (1d + Math.exp(sum)));
        }

    }

    public double getBias() {
        return bias;
    }

    public void setBias(double bias) {
        this.bias = bias;
    }

    public double[] getInputWeights() {
        return inputWeights;
    }

    public double getOutput() {
        return output;
    }

    void setOutput(double output) {
        this.output = output;
    }

}

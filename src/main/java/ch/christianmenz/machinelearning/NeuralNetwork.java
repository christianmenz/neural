package ch.christianmenz.machinelearning;

/**
 *
 * @author Christian
 */
public class NeuralNetwork {

    private Neuron[][] neurons;
    
    private double[] input;
    
    private double[] output;

    public NeuralNetwork(int... layers) {
        neurons = new Neuron[layers.length][];
        for (int layer = 0; layer < layers.length; layer++) {
            neurons[layer] = new Neuron[layers[layer]];

            for (int neuron = 0; neuron < layers[layer]; neuron++) {
                neurons[layer][neuron] = new Neuron(this, layer);
            }
        }
    }

    public Neuron[][] getNeurons() {
        return neurons;
    }

    public double[] getInput() {
        return input;
    }
  
    double[] activate(double[] input) {
        this.input = input;
        for (int layer = 1; layer < neurons.length; layer++) {           
            for (int n = 0; n < neurons[layer].length; n++) {
                Neuron neuron = neurons[layer][n];                                
                neuron.activate();
            }
        }
        
        Neuron[] outputLayer = neurons[neurons.length -1];
        
        output = new double[outputLayer.length];
        for (int i = 0; i < outputLayer.length; i++) {
            output[i] = outputLayer[i].getOutput();
        }
        return output;
    }

}

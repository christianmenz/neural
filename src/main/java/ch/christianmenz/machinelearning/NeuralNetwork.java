package ch.christianmenz.machinelearning;

/**
 *
 * @author Christian
 */
public class NeuralNetwork {
    
    private Neuron[][] neurons;
    
    public NeuralNetwork(int... layers ) {
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
              
}

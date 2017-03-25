package ch.christianmenz.machinelearning;

import java.util.List;

/**
 *
 * @author Christian
 */
public class Trainer {
    
    private final NeuralNetwork network;
    
    private final TrainingSet trainingSet;
    private final double learningRate;
    private double currentError = Double.MAX_VALUE;
    
    public Trainer(NeuralNetwork net, TrainingSet trainingSet, double learningRate) {
        this.network = net;
        this.trainingSet = trainingSet;
        this.learningRate = learningRate;
    }
    
    public void train() {
        double epochError = 0;
        List<TrainingRow> trainingRows = trainingSet.getTrainingRows();
        for (TrainingRow trainingRow : trainingRows) {
            double[] outputs = network.activate(trainingRow.getInput());
            
            for (int i = 0; i < outputs.length; i++) {
                double expectedOut = trainingRow.getOutput()[i];
                double actualOut = outputs[i];
                double error = actualOut - expectedOut;
                epochError += Math.pow(error, 2); // square error

                // backpropagate..
                for (int layer = network.getNeurons().length - 1; layer > 0; layer--) { 
                    for (int n = 0; n < network.getNeurons()[layer].length; n++) {
                        Neuron neuron = network.getNeurons()[layer][n];
                        Neuron[] inputNeurons = network.getNeurons()[layer - 1];
                        
                        for (int z = 0; z < inputNeurons.length; z++) {
                            double changeWeight = learningRate * error * inputNeurons[z].getOutput() * neuron.getOutput() * (1.d - neuron.getOutput());
                            neuron.getInputWeights()[z] = neuron.getInputWeights()[z] + changeWeight; // I know how this feels.. but maybe the perormance is good                            
                        }
                        // update bias
                        double changeWeight = learningRate * error * 1d * neuron.getOutput() * (1 - neuron.getOutput());
                        neuron.setBias(neuron.getBias() + changeWeight);                        
                    }
                }
                
            }
            
        }
        this.currentError = epochError;
    }
    
    public double getCurrentError() {
        return currentError;
    }
    
}

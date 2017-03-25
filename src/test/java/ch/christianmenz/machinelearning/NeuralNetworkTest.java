/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.christianmenz.machinelearning;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Christian
 */
public class NeuralNetworkTest {

    public NeuralNetworkTest() {
    }

    /**
     * Test of main method, of class Main.
     */
    @Test
    public void shouldTrainXOR() {
        int epochs = 10000;
        NeuralNetwork net = new NeuralNetwork(2, 2, 1);

        TrainingSet trainingSet = new TrainingSet();
        trainingSet.addRow(new TrainingRow(new double[]{0, 1}, new double[]{1}));
        trainingSet.addRow(new TrainingRow(new double[]{1, 1}, new double[]{0}));
        trainingSet.addRow(new TrainingRow(new double[]{1, 0}, new double[]{1}));
        trainingSet.addRow(new TrainingRow(new double[]{0, 0}, new double[]{0}));

        Trainer trainer = new Trainer(net, trainingSet, 0.25d);

        for (int i = 0; i < epochs; i++) {
            trainer.train();
            System.out.println("Network error: " + trainer.getCurrentError());
        }

        double[] output = net.activate(new double[]{0, 1});
        assertEquals(1, output[0], 0.1);

        output = net.activate(new double[]{1, 0});
        assertEquals(1, output[0], 0.1);

        output = net.activate(new double[]{0, 0});
        assertEquals(0, output[0], 0.1);

        output = net.activate(new double[]{1, 1});
        assertEquals(0, output[0], 0.1);

    }

}

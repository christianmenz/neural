/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

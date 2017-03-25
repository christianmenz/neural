/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.christianmenz.machinelearning;

import java.util.LinkedList;

/**
 *
 * @author Christian
 */
public class TrainingSet {

    private LinkedList<TrainingRow> trainingRows = new LinkedList<>();

    public TrainingSet() {
    }

    public void addRow(TrainingRow trainingRow) {
        trainingRows.add(trainingRow);
    }

}

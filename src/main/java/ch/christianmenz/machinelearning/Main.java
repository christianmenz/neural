package ch.christianmenz.machinelearning;

/**
 *
 * @author Christian
 */
public class Main {
    
     public static void main(String[] args) {
        long start = System.currentTimeMillis();
        NeuralNetwork net = new NeuralNetwork(4000, 4000, 4000, 4000, 2000);
        
        System.out.println(System.currentTimeMillis() - start);
    }
    
}

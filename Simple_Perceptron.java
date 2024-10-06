import java.util.Random;

public class Simple_Perceptron {

    double[] weights;
    double lr = 0.01;

    //constructor to initialize weights randomly
    Simple_Perceptron(int n) {
        this.weights = new double[n];
        Random rand = new Random();
        for (int i = 0; i < this.weights.length; i++) {
            this.weights[i] = rand.nextDouble(2) - 1;
        }
    }

    //predicts with the help of the weights whether it is above or below the line
    public int predict(double[] input) {
        if(input.length != this.weights.length) {
            return -2;
        } else {
            double sum = 0;
            for (int i = 0; i < this.weights.length; i++) {
                sum += this.weights[i] * input[i];
            }
            return activationFunction(sum);
        }
    }

    //this predicts the y coordinate for the prediction line based on the weights
    public double predictY(double givenX) {
        return -weights[0]/weights[1] * givenX - weights[2]/weights[1];
    }

    //adjusts the weights based on the prediction compared to the target
    public void train(double[] input, int target) {
        int prediction = predict(input);
        int error = target - prediction;

        for(int i = 0; i < this.weights.length; i++) {
            this.weights[i] += error * input[i] * lr;
        }
    }

    private int activationFunction(double sum) {
        if(sum >= 0) {
            return 1;
        } else {
            return -1;
        }
    }
}

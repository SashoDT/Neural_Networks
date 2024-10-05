import java.util.Random;

public class Simple_Perceptron {

    float[] weights = new float[2];
    double lr = 0.1;

    //constructor to initialize weights randomly
    Simple_Perceptron() {
        Random rand = new Random();
        for (int i = 0; i < this.weights.length; i++) {
            this.weights[i] = rand.nextFloat(2) - 1;
        }
    }

    //predicts with the help of the weights whether it is above or below the line
    public int predict(float[] input) {
        if(input.length != this.weights.length) {
            return -2;
        } else {
            float sum = 0;
            for (int i = 0; i < this.weights.length; i++) {
                sum += this.weights[i] * input[i];
            }
            return activationFunction(sum);
        }
    }

    //adjusts the weights based on the prediction compared to the target
    public void train(float[] input, int target) {
        int prediction = predict(input);
        int error = target - prediction;

        for(int i = 0; i < this.weights.length; i++) {
            this.weights[i] += (float)(error * input[i] * lr);
        }
    }

    private int activationFunction(float sum) {
        if(sum >= 0) {
            return 1;
        } else {
            return -1;
        }
    }
}

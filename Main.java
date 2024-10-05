import codedraw.*;

import java.awt.*;


public class Main {

    public static void main(String[] args) {
        Simple_Perceptron perceptron = new Simple_Perceptron();
        int dimension = 600;
        CodeDraw canvas = new CodeDraw(dimension, dimension);
        Points[] points = new Points[400];

        // initialize all the points with random coordinates
        for(int i = 0; i < points.length; i++) {
            points[i] = new Points(dimension);
        }

        // draw the individual points on the canvas
        for(Points p : points) {
            p.show(canvas);
        }
        canvas.setColor(Color.BLUE);
        canvas.drawLine(0, 0, dimension, dimension);

        // train the perceptron
        for(Points p : points) {
            float[] inputs = {p.x, p.y};
            int target = p.label;

            perceptron.train(inputs, target);

            //use this to visualize learning with and without a prediction
            int prediction = perceptron.predict(inputs);
            if(prediction == target) {
                canvas.setColor(Color.GREEN);
            } else {
                canvas.setColor(Color.RED);
            }
            canvas.fillCircle(p.x, p.y, 3);
        }

        canvas.show();
    }
}

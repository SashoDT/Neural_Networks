import codedraw.*;

import java.awt.*;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        Simple_Perceptron perceptron = new Simple_Perceptron(3);
        int dimension = 600;
        CodeDraw canvas = new CodeDraw(dimension, dimension);
        Points[] points = new Points[400];

        //initialize all the points with random coordinates
        for(int i = 0; i < points.length; i++) {
            points[i] = new Points();
        }

        //train the perceptron
        for (Points p : points) {
            //clear the canvas
            canvas.clear();

            //redraw the original points
            for (Points point : points) {
                point.show(canvas, dimension);
            }

            //redraw the actual function line
            canvas.setColor(Color.BLUE);
            Points p1 = new Points(-1);
            Points p2 = new Points(1);
            canvas.drawLine(p1.mapX(p1.x, dimension), p1.mapY(p1.y, dimension),
                    p2.mapX(p2.x, dimension), p2.mapY(p2.y, dimension));

            //pass the original x and y values, not the mapped values
            double[] inputs = {p.x, p.y, p.bias};
            int target = p.label;

            perceptron.train(inputs, target);

            //draw the prediction line based on updated weights
            canvas.setColor(Color.BLACK);
            Points p3 = new Points(-1, perceptron.predictY(-1));
            Points p4 = new Points(1, perceptron.predictY(1));
            canvas.drawLine(p3.mapX(p3.x, dimension), p3.mapY(p3.y, dimension),
                    p4.mapX(p4.x, dimension), p4.mapY(p4.y, dimension));

            canvas.show();
            Thread.sleep(50);  // Delay for visualization
        }

        //loop to see which points will be correctly classified
        for (Points p : points) {
            double[] inputs = {p.x, p.y, p.bias};
            int target = p.label;
            int prediction = perceptron.predict(inputs);
            if (prediction == target) {
                canvas.setColor(Color.GREEN);
            } else {
                canvas.setColor(Color.RED);
            }
            canvas.fillCircle(p.mapX(p.x, dimension), p.mapY(p.y, dimension), 3);

            canvas.show();
        }

    }
}

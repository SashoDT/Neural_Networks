import codedraw.CodeDraw;
import java.awt.*;
import java.util.Random;

public class Points {
    double x;
    double y;
    int bias = 1;
    int label;

    Points() {
        Random rand = new Random();
        this.x = rand.nextDouble(2) - 1;
        this.y = rand.nextDouble(2) - 1;
        double actualY = this.f(this.x);

        //check whether the point is above or below the line
        if(this.y > actualY) {
            label = 1;
        } else {
            label = -1;
        }
    }

    Points(double givenX) {
        this.x = givenX;
        this.y = this.f(givenX);
    }

    Points(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //maps the randomly generated x (between -1 and 1) to a cartesian space with the limits of the canvas dimension
    public double mapX(double xP, double dimension) {
        return ((xP + 1) / 2) * dimension;
    }

    //maps the randomly generated y (between -1 and 1) to a cartesian space with the limits of the canvas dimension
    public double mapY(double yP, double dimension) {
        return (1 - ((yP + 1) / 2)) * dimension;
    }

    public void show(CodeDraw canvas, double dimension) {
        canvas.setColor(Color.BLACK);
        if(label == 1) {
            canvas.fillCircle(mapX(this.x, dimension), mapY(this.y, dimension), 6);
        } else {
            canvas.drawCircle(mapX(this.x, dimension), mapY(this.y, dimension), 6);
        }
    }

    public double f(double x) {
        //specify your line function y = mx + n (m, n should be between -1 and 1)
        return -0.6 * x + 0.2;
    }
}

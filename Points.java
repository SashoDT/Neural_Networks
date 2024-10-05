import codedraw.CodeDraw;

import java.awt.*;
import java.util.Random;

public class Points {
    float x;
    float y;
    int label;

    Points(int dimension) {
        Random rand = new Random();
        this.x = rand.nextFloat(dimension);
        this.y = rand.nextFloat(dimension);

        if(this.x > this.y) {
            label = 1;
        } else {
            label = -1;
        }
    }

    public void show(CodeDraw canvas) {
        canvas.setColor(Color.BLACK);
        if(label == 1) {
            canvas.fillCircle(this.x, this.y, 6);
        } else {
            canvas.drawCircle(this.x, this.y, 6);
        }
    }
}

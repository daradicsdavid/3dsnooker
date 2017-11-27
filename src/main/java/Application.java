import processing.core.PApplet;

public class Application extends PApplet {
    public static void main(String[] args) {
        String[] processingArgs = {"Application"};
        Application application = new Application();
        PApplet.runSketch(processingArgs, application);
    }

    public void settings() {
        size(1500, 1500, P3D);
    }

    public void draw() {
        translate(400,400,  0);
        drawCylinder(5, 50, 50);
    }

    void drawCylinder(int sides, float r, float h) {
        float angle = 360 / sides;
        float halfHeight = h / 2;
        // draw top shape
        beginShape();
        for (int i = 0; i < sides; i++) {
            float x = cos(radians(i * angle)) * r;
            float y = sin(radians(i * angle)) * r;
            vertex(x, y, -halfHeight);
        }
        endShape(CLOSE);
        // draw bottom shape
        beginShape();
        for (int i = 0; i < sides; i++) {
            float x = cos(radians(i * angle)) * r;
            float y = sin(radians(i * angle)) * r;
            vertex(x, y, halfHeight);
        }
        endShape(CLOSE);

        beginShape(TRIANGLE_STRIP);
        for (int i = 0; i < sides + 1; i++) {
            float x = cos(radians(i * angle)) * r;
            float y = sin(radians(i * angle)) * r;
            vertex(x, y, halfHeight);
            vertex(x, y, -halfHeight);
        }
        endShape(CLOSE);
    }
}

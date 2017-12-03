package physics;

public class CollisionResponse {

    public float t;
    private static final float T_EPSILON = 0.005f;

    public float newSpeedX;

    public float newSpeedY;

    public CollisionResponse() {
        reset();
    }

    public void reset() {
        this.t = Float.MAX_VALUE;
    }


    public void copy(CollisionResponse another) {
        this.t = another.t;
        this.newSpeedX = another.newSpeedX;
        this.newSpeedY = another.newSpeedY;
    }

    public float getNewX(float currentX, float speedX) {
        if (t > T_EPSILON) {
            return (currentX + speedX * (t - T_EPSILON));
        } else {
            return currentX;
        }
    }

    public float getNewY(float currentY, float speedY) {
        if (t > T_EPSILON) {
            return (currentY + speedY * (t - T_EPSILON));
        } else {
            return currentY;
        }
    }

    public double getImpactX(float currentX, float speedX) {
        return currentX + speedX * t;
    }


    public double getImpactY(float currentY, float speedY) {
        return currentY + speedY * t;
    }

}

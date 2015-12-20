import java.util.*;

public class Ball {

    private double rx, ry; // position
    private double vx, vy; // velocity 
    private final double radius; 
    private final Random generator;

    public Ball () {
	this.generator = new Random();
	this.rx = ((double) generator.nextInt(100) ) / 100.0;
	this.ry = ((double) generator.nextInt(100) ) / 100.0;
	this.vx = ((double) generator.nextInt(21) - 10 ) / 100.0;
	this.vy = ((double) generator.nextInt(21) - 10) / 100.0;
	this.radius = 0.01;
    }

    public void move(double dt) {
	if ((rx + vx*dt < radius) || (rx + vx*dt > 1.0 - radius)) {vx = -vx;}
	if ((ry + vy*dt < radius) || (ry + vy*dt > 1.0 - radius)) {vy = -vy;}
	rx += vx*dt;
	ry += vy*dt;
    }

    public void draw () {
	StdDraw.filledCircle(rx, ry, radius);
    }

}
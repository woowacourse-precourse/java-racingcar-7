package racingcar.model;

public class Vehicle implements Movable{
    protected static final int DEFAULT_POSITION = 0;
    protected static final int DEFAULT_SPEED = 1;

    protected int speed;
    protected String name;
    protected int position;
    protected MovementTracker movementTracker;

    public Vehicle(String name) {
        this.name = name;
        this.position = DEFAULT_POSITION;
        this.speed = DEFAULT_SPEED;
        this.movementTracker = new MovementTracker();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String showMovement(){
        return movementTracker.getMovement();
    }

    @Override
    public void moveForward(){
        position += speed;
        movementTracker.recordMovement(speed);
    }

    @Override
    public void stopMoving(){
    }
}

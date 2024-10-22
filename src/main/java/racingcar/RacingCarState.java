package racingcar;

public class RacingCarState {
    private final Car car;
    private int position;

    public RacingCarState(Car car) {
        this.car = car;
        this.position = 0;
    }

    public String getCarName() {
        return car.getName();
    }

    public int getPosition() {
        return position;
    }


    public void tryToMove(MoveCondition moveCondition) {
        if(moveCondition.isMovable(this)){
            position++;
        }
    }
}

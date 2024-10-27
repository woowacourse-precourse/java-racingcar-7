package racingcar.model;

public class RacingCar {

    public String name;
    private int movedDistance = 0;

    public RacingCar(String name){
        this.name = name;
    }

    public void moveForward(){
        this.movedDistance+=1;
    }

    public int getMovedDistance() {
        return movedDistance;
    }
}

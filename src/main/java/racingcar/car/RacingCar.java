package racingcar.car;

public class RacingCar {
    private final MovementDistance movementDistance;

    private RacingCar(MovementDistance movementDistance){
        this.movementDistance = movementDistance;
    }

    public static RacingCar create(){
        return new RacingCar(
                MovementDistance.initializeDistance()
        );
    }

    public RacingCar increaseDistanceBy(int stepCount) {
       return new RacingCar(
               this.movementDistance.increaseDistanceBy(stepCount)
       );
    }

    public RacingCar maintainCurrentPosition() {
        return new RacingCar(
                this.movementDistance
        );
    }

    public int provideCurrentPosition() {
        return this.movementDistance.getValue();
    }

}

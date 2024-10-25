package racingcar.car;

public class Car {
    private final MovementDistance movementDistance;

    private Car(MovementDistance movementDistance){
        this.movementDistance = movementDistance;
    }

    public static Car createNamedCar(){
        return new Car(
                MovementDistance.initializeDistance()
        );
    }

    public Car increaseDistanceBy(int stepCount) {
       return new Car(
               this.movementDistance.increaseDistanceBy(stepCount)
       );
    }

    public Car maintainCurrentPosition() {
        return new Car(
                this.movementDistance
        );
    }

    public int provideCurrentPosition() {
        return this.movementDistance.getValue();
    }

}

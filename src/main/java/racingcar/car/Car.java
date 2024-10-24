package racingcar.car;

public class Car {
    private final CarName carName;
    private final MovementDistance movementDistance;

    private Car(CarName carName, MovementDistance movementDistance){
        this.carName = carName;
        this.movementDistance = movementDistance;
    }
    public static Car createNamedCar(String carName){
        return new Car(
                CarName.createCarName(carName),
                MovementDistance.initialzeDistance()
        );
    }

    public Car increaseDistanceBy(int stepCount) {
       return new Car(
               this.carName,
               this.movementDistance.increaseDistanceBy(stepCount)
       );
    }

    public Car maintainCurrentPosition() {
        return new Car(
                this.carName,
                this.movementDistance
        );
    }

    public int provideCurrentPosition() {
        return this.movementDistance.getValue();
    }

    public String provideCarName() {
        return this.carName.getValue();
    }
}

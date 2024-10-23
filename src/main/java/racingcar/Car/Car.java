package racingcar.Car;

public class Car {
    private final CarName carName;
    private final Distance distance;

    private Car(CarName carName, Distance distance){
        this.carName = carName;
        this.distance = distance;
    }
    public static Car createNamedCar(String carName){
        return new Car(
                CarName.createCarName(carName),
                Distance.initialzeDistance()
        );
    }

    public Car increaseDistanceBy(int stepCount) {
       return new Car(
               this.carName,
               this.distance.increaseDistanceBy(stepCount)
       );
    }

    public void maintainCurrentPosition() {

    }

    public int provideCurrentPosition() {
        return this.distance.getValue();
    }

    public String provideCarName() {
        return this.carName.getValue();
    }
}

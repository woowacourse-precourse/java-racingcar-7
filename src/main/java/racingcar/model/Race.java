package racingcar.model;

public class Race {
    private final RandomNumberGenerator randomNumberGenerator;

    public Race(RandomNumberGenerator randomNumberGenerator){
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public Cars startRace(Cars cars) {
        for(Car car : cars.getCars()){
            int randomNumber = randomNumberGenerator.makeRandomNumber();
            car.move(randomNumber);
        }
        return cars;
    }
}

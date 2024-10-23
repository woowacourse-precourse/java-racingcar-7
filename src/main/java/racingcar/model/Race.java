package racingcar.model;

public class Race {
    Cars cars;
    Integer raceCount;

    public Race(Cars cars, Integer raceCount) {
        this.cars = cars;
        this.raceCount = raceCount;
    }
    public Cars getCars() {
        return cars;
    }

    public Integer getRaceCount() {
        return raceCount;
    }
}

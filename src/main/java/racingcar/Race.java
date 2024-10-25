package racingcar;

import java.util.List;

public class Race {
    private List<Car> cars;
    private MovementDecider movementDecider = new RandomMovementDecider();

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public RoundResult getRoundResult() {

        List<CarDto> carDtoList = cars.stream().map(car ->
                        new CarDto(car.getName(), car.getCurrentPosition()))
                .toList();

        return new RoundResult(carDtoList);
    }

    public void start() {
        cars.forEach(car -> car.moveOrStop(movementDecider));
    }

    public Winners getFinalWinners() {
        List<Car> sortedCars = sortByPositionDescending();
        int winnerPosition = sortedCars.getFirst().getCurrentPosition();
        return new Winners(findWinners(winnerPosition));
    }

    private List<Car> sortByPositionDescending() {
        List<Car> cars = this.cars.stream().sorted((a, b) -> {
            return b.getCurrentPosition() - a.getCurrentPosition();
        }).toList();
        return cars;
    }

    private List<String> findWinners(int winnerPosition) {
        return cars.stream().filter(car -> {
            return car.getCurrentPosition() == winnerPosition;
        }).map(car -> car.getName()).toList();
    }

}

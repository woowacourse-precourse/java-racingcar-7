package racingcar.domain;

import java.util.List;
import racingcar.dto.CarDto;
import racingcar.dto.RoundResult;
import racingcar.dto.Winners;

public class Race {
    private final List<Car> cars;
    private final MovementDecider movementDecider;

    public Race(List<Car> cars, MovementDecider movementDecider) {
        this.cars = cars;
        this.movementDecider = movementDecider;
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
        List<CarDto> sortedCars = sortByPositionDescending();
        List<CarDto> winnerCarsDto = findWinners(sortedCars);
        return new Winners(winnerCarsDto);
    }

    private List<CarDto> sortByPositionDescending() {
        RoundResult roundResult = getRoundResult();
        return roundResult.getCarDtoList().stream().sorted((a, b) -> {
            return b.getCurrentPosition() - a.getCurrentPosition();
        }).toList();
    }

    private List<CarDto> findWinners(List<CarDto> sortedCars) {
        int winnerPosition = sortedCars.getFirst().getCurrentPosition();
        return sortedCars.stream().
                filter(carDto -> carDto.getCurrentPosition() == winnerPosition)
                .toList();
    }
}

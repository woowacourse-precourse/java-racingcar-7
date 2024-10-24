package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.dto.FinalResultDto;
import racingcar.dto.RoundResultDto;

public class RacingGame {

    private final CarMover carMover;
    private final List<RoundResultDto> roundResultList = new ArrayList<>();

    public RacingGame(CarMover carMover) {
        this.carMover = carMover;
    }

    public FinalResultDto playRacingGame(int roundNumber, List<Car> carList) {
        for (int i = 0; i < roundNumber; i++) {
            carMover.moveCars(carList);
            roundResultList.add(new RoundResultDto(i + 1, carList));
        }

        return new FinalResultDto(roundResultList, determineWinner(carList));
    }

    private List<String> determineWinner(List<Car> carList) {
        int maxPosition = carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }
}

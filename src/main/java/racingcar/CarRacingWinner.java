package racingcar;

import java.util.List;

public class CarRacingWinner {

    private final List<Car> winners;

    CarRacingWinner(CarGroup carGroup) {
        winners = carGroup.getLongestMileageCars();
    }

    private String toStringWinnersName() {
        List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .toList();
        return String.join(",", winnerNames);
    }

    @Override
    public String toString() {
        return "최종 우승자 : " + toStringWinnersName();
    }
}

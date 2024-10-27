package racingcar;

import java.util.List;

public class CarRacingWinner {

    private final CarGroup carGroup;

    CarRacingWinner(CarGroup carGroup) {
        this.carGroup = carGroup;
    }

    private String getWinnersName() {
        List<String> winnerNames = carGroup.getLongestMileageCars()
                .stream()
                .map(Car::getName)
                .toList();
        return String.join(",", winnerNames);
    }

    public String getWinners() {
        return "최종 우승자 : " + getWinnersName();
    }
}

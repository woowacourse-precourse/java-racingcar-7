package racingcar;

import utils.ExceptionMessages;
import utils.Splitter;

import java.util.List;

public class Race {
    private final int MIN_PARTICIPANT_COUNT = 2;

    private Cars competingCars;
    private int moveAttemptsCount;

    public Race(String names, int moveAttemptsCount) {
        List<String> carNameList = Splitter.splitCarName(names);
        this.competingCars = validateAndJoinCar(carNameList);
        this.moveAttemptsCount = moveAttemptsCount;
    }

    private Cars validateAndJoinCar(List<String> carNameList) {
        if (carNameList.size() < MIN_PARTICIPANT_COUNT) {
            throw new IllegalArgumentException(ExceptionMessages.MINIMUM_TWO_CARS_REQUIRED);
        }
        return new Cars(carNameList);
    }

    private void printRacingStatus() {
        System.out.println(competingCars.toString());
    }

    public void startWithPrint() {
        System.out.println("\n실행결과");
        for (int i = 0; i < moveAttemptsCount; i++) {
            competingCars.moveAll();
            printRacingStatus();
        }
    }

    public void printWinners() {
        List<String> winners = competingCars.findWinnersName();
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }
}

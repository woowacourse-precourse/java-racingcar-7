package racingcar.view.impl;

import static racingcar.common.constant.OutputMessage.OUTPUT_ROUND_RESULT;
import static racingcar.common.constant.OutputMessage.OUTPUT_WINNER;

import java.util.stream.Collectors;
import racingcar.domain.CarDomain;
import racingcar.domain.CarDomains;
import racingcar.view.OutputView;

public class ConsoleOutputView implements OutputView {
    private static ConsoleOutputView INSTANCE;

    private ConsoleOutputView() {
    }

    public static synchronized ConsoleOutputView getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ConsoleOutputView();
        }
        return INSTANCE;
    }

    @Override
    public void displayRoundResultString() {
        System.out.println(
                System.lineSeparator() + OUTPUT_ROUND_RESULT.getMessage()
        );
    }

    @Override
    public void displayEachRoundStatus(CarDomains cars) {
        System.out.println(
                cars.getCarDomainList().stream()
                        .map(car -> car.getName() + " : " + "-".repeat(car.getDistance()))
                        .collect(Collectors.joining(System.lineSeparator())) + System.lineSeparator()
        );
    }

    @Override
    public void displayCarRaceWinner(CarDomains winners) {
        System.out.println(
                OUTPUT_WINNER.getMessage() + winners.getCarDomainList().stream()
                        .map(CarDomain::getName)
                        .collect(Collectors.joining(", "))
        );
    }
}

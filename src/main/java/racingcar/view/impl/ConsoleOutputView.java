package racingcar.view.impl;

import static racingcar.common.constant.OutputMessage.INPUT_CAR_NAMES;
import static racingcar.common.constant.OutputMessage.INPUT_ROUND;
import static racingcar.common.constant.OutputMessage.OUTPUT_ROUND_RESULT;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.CarDomain;
import racingcar.view.OutputView;

public class ConsoleOutputView implements OutputView {
    @Override
    public String displayCarNameRequest() {
        return INPUT_CAR_NAMES.getMessage();
    }

    @Override
    public String displayRoundRequest() {
        return INPUT_ROUND.getMessage();
    }

    @Override
    public String displayRoundResultString() {
        return OUTPUT_ROUND_RESULT.getMessage();
    }

    @Override
    public String displayEachRoundStatus(List<CarDomain> cars) {
        return cars.stream()
                .map(car -> car.getName() + " : " + "-".repeat(car.getDistance()))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String displayCarRaceWinner(List<CarDomain> winners) {
        return "최종 우승자 : " + winners.stream()
                .map(CarDomain::getName)
                .collect(Collectors.joining(", "));
    }
}

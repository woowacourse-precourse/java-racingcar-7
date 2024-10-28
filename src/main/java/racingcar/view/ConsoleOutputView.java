package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleOutputView extends OutputView {

    @Override
    public void displayOutput(final List<RacingCar> winners) {

        String winnerList = winners.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + winnerList);
    }
}

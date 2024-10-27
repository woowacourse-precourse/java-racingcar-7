package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.RacingCar;

public class OutputView {

    public static void printWinner(List<RacingCar> winners) {

        String winnerNames = winners.stream().map(RacingCar::getCarName).collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + winnerNames);
    }
}

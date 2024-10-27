package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class ResultOutput {

    public void print(List<RacingCar> winners) {

        String winnerNames = winners.stream()
                .map(RacingCar::getCarName)
                .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + winnerNames);
    }
}

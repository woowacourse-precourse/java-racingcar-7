package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.RacingCar;

public class RacingCarView {
    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public String inputRound() {
        System.out.println("시도할 횟수는 몇 회인가요? ");
        return Console.readLine();
    }

    public void printResult(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(List<RacingCar> winners) {
        String winnerNames = winners.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + winnerNames);
    }
}

package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.RacingCar;

public class RacingCarIOHandler {

    public String askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public String askRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String roundCountString = Console.readLine();
        Console.close();
        return roundCountString;
    }

    public void showRacingCarsProgress(List<RacingCar> racingCars) {
        racingCars.stream()
                .forEach(racingCar -> System.out.printf("%s : %s%n",
                        racingCar.getName(), racingCar.getProgress()));
        System.out.println();
    }
}

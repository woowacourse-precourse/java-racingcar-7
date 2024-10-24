package racingcar.io;

import java.util.List;
import racingcar.car.RacingCar;

public class OutputHandler {

    public void showCarNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void showRoundInputMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void showExecutionResultMessage() {
        System.out.println("\n실행결과");
    }

    public void showRacingCarsProgress(List<RacingCar> cars) {
        cars.forEach(car -> System.out.printf("%s : %s%n", car.getName(), car.getProgress()));
    }

    public void showWinners(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.printf("최종 우승자 : %s%n", result);
    }
}

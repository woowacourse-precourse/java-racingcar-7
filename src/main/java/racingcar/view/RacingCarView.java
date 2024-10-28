package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

import java.util.List;

public class RacingCarView {
    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return List.of(Console.readLine().split(","));
    }

    public String inputRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine().trim();
    }

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getPosition());
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}

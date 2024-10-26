package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Car;

/**
 * ConsoleView
 * : 사용자로부터 입력을 받고 Controller에 전달
 * : Controller에게 받은 과정 및 결과 출력
 */

public class ConsoleView {

    public String requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public String requestNumberOfAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    public void displayExecutionResultHeader() {
        System.out.println("\n실행 결과");
    }

    public void displayRaceStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void displayRaceResult(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}

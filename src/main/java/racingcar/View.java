package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class View {
    public String scanCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public String scanAttemptCount(List<Car> cars) {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    public void printCarsProgress(List<Car> cars) {
        System.out.println("\n실행 결과");
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getProgress());
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}

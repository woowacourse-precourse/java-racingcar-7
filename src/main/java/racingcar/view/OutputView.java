package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public static void printCarNamesInputGuide() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printMoveCountInputGuide() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void printRunMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printGameStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    public static void printGameResult(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}

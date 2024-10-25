package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    public static void printCarNamesPrompt() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printAttemptCountPrompt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void printCarMove(List<Car> carNames) {
        for (Car carName : carNames) {
            System.out.print(carName.getName() + " : ");
            System.out.println("-".repeat(carName.getPosition()));
        }
    }


}

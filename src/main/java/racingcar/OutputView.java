package racingcar;

import java.util.List;

public class OutputView {
    public void notifyEnterNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void notifyEnterTryingNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void notifyPrintResult() {
        System.out.println("실행 결과");
    }

    public void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName()+" : ");
            printCurrentPos(car.getCurrentPos());
            System.out.print("\n");
        }
    }

    public void printCurrentPos(int currentPos) {
        for (int i = 0; i < currentPos; i++) {
            System.out.print("-");
        }
    }
}

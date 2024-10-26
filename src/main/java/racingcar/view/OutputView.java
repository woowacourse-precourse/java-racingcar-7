package racingcar.view;

import racingcar.model.Car;

public class OutputView {

    public void startMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void roundMessage() {
        System.out.println("시도할 회수는 몇 회인가요?");
    }

    public void executeMessage() {
        System.out.println("실행 결과");
    }

    public void roundEndMessage(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getForwardCount(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}

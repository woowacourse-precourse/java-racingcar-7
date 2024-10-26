package racingcar.view;

import racingcar.model.Car;

public class OutputView {

    private final Car car;

    public OutputView(Car car) {
        this.car = car;
    }

    public void printCarNameProvideMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printTryCountProvideMessage() {
        System.out.println("시도할 횟수");
    }

    public void printExecutionResult() {
        System.out.println("실행 결과");
    }

    public void printCarNameAndMovingStatus() {
        System.out.println(car.getName() + " : " + car.getMoveStatus());
    }

}

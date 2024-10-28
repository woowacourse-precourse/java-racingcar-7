package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    public void printCarNameInputRequest() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printTryCountInputRequest() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printStepResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printFinalFirstPlaceCars(List<String> firstPlaceCarsList) {
        System.out.println("최종 우승자 : " + String.join(", ", firstPlaceCarsList));
    }
}

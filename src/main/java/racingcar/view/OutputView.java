package racingcar.view;

import racingcar.model.Car;

import java.util.ArrayList;

public class OutputView {

    public void askCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void askTurn() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }


    public void printResult() {
        System.out.println("실행 결과");
    }

    public void printCarPostion(ArrayList<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinner(ArrayList<String> winnerList) {
        System.out.println(
                "최종 우승자 : " + String.join(", ", winnerList)
        );
    }
}

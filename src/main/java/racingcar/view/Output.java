package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class Output {

    public void printCarInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printNumInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }
    public void printStart() {
        System.out.println("실행 결과");
    }


    public void printTurn(List<Car> carList) {
        for(Car car : carList) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinner(List<String > winnerList) {
        System.out.println("최종 우승자 : " + String.join(",", winnerList));
    }
}

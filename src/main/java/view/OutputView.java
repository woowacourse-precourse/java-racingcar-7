package view;

import java.util.List;
import model.Car;

public class OutputView {

    static public void printGuide() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    static public void printAttemptPrompt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printRaceStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getPositionStatus());
        }
        System.out.println();
    }

    public void printFinalWinner(List<String> finalWinners) {
        String result = String.join(", ", finalWinners);
        System.out.println("최종 우승자 : " + result);
    }
}

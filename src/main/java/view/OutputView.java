package view;

import java.util.ArrayList;
import java.util.List;
import model.Car;

public class OutputView {

    public void printGuide() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printAttemptPrompt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printCurrentStatus(Car car) {
        String result = car.getPositionStatus();
        System.out.println(result);
    }

    public List<String> findFinalWinners(List<Car> cars) {
        List<String> finalWinners = new ArrayList<>();
        int tmp = 0;
        for (Car car : cars) {
            if (car.getPosition() >= tmp) {
                tmp = car.getPosition();
            }
        }
        for (Car car : cars) {
            if (car.getPosition() == tmp) {
                finalWinners.add(car.getName());
            }
        }
        return finalWinners;
    }

    public void printFinalWinner(List<String> finalWinners) {
        String result = String.join(", ", finalWinners);
        System.out.println("최종 우승자 : " + result);
    }
}

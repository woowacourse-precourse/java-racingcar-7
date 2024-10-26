package racingcar.view;

import racingcar.model.Car;

import java.util.List;

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

    public void endGameMessage(List<String> winnerCars) {
        System.out.print("\n최종 우승자 : ");

        for (int i = 0; i < winnerCars.size(); i++) {
            System.out.print(winnerCars.get(i));
            if (i < winnerCars.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}

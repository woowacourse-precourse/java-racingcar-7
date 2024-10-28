package racingcar.outputview;

import racingcar.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputHandler {

    public void promptCarNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void promptAttemptCountInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void showGameResult() {
        System.out.println("실행 결과");
    }

    public void showCurrentCarPosition(List<Car> carList) {
        for (Car car : carList) {
            StringBuilder sb = new StringBuilder();
            int count = car.getPosition();

            System.out.print(car.getName() + " : ");
            sb.append("-".repeat(Math.max(0, count)));
            System.out.print(sb + "\n");
        }
        System.out.println();
    }

    public void showWinners(List<Car> carList) {
        System.out.println("최종 우승자 : " + carList.stream().map(Car::getName).collect(Collectors.joining(", ")));
    }
}

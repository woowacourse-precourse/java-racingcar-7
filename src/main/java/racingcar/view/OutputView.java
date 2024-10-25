package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    public void printRunResult() {
        System.out.println("\n" + "실행 결과");
    }

    public void printRoundResult(List<Car> carList) {
        carList.forEach(car -> System.out.println(car.generateCarState()));
        System.out.println();
    }

    public void printWinnerPlayers(String players) {
        System.out.println("최종 우승자 : " + players);
    }
}

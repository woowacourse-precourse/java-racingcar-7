package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public void printRaceStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String joinedWinners = String.join(", ", winners);
        System.out.println("최종 우승자 : " + joinedWinners);
    }

    public void printProcess() {
        System.out.println();
        System.out.println("실행 결과");
    }
}

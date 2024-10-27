package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    public void printRaceResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        // 라운드 간 간격을 위한 빈 줄 출력
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}

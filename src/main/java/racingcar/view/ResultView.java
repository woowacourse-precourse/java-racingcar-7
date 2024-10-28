package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.List;

public class ResultView {

    public void printStartMessage() {
        System.out.println("실행 결과");
    }

    public void printRaceResult(Cars cars) {
        List<Car> carList = cars.getCars();
        for (Car car : carList) {
            System.out.println(car.toString());
        }
        System.out.println();
    }

    public void printWinners(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}

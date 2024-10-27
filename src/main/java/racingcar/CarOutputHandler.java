package racingcar;

import java.util.List;

public class CarOutputHandler {
    public void printCarRacingProgress(List<Car> carList, int roundNumber) {
        System.out.println("실행 결과");
        for (Car car : carList) {
            System.out.println(car.getCarName() + " : " + car.displayPosition());
        }
        System.out.println();
    }

    public void runRace(List<Car> carList, int howManyTimesMove) {
        for (int i = 0; i < howManyTimesMove; i++) {
            for (Car car : carList) {
                car.carMove();
            }
            printCarRacingProgress(carList, i + 1);
        }
    }
}

package racingcar;

import java.util.List;

public class OutputView {
    private final String dash = "-";

    public void startGame(List<Car> carList, int tryCount) {
        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < tryCount; i++) {
            for (Car car: carList) {
                Validator.forwardOrStop(car);
            }
            printMovingCar(carList);
        }

    }

    private void printMovingCar(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + printDash(car));
        }
        System.out.println();
    }

    private String printDash(Car car) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < car.getMoveCount(); i++) {
            result.append(dash);
        }

        return result.toString();
    }
}

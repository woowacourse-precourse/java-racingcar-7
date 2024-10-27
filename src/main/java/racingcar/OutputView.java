package racingcar;

import java.util.List;

public class OutputView {
    private final String dash = "-";
    private final RaceWinner raceWinner;

    public OutputView(RaceWinner raceWinner) {
        this.raceWinner = raceWinner;
    }

    public void startGame(List<Car> carList, int tryCount) {
        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < tryCount; i++) {
            for (Car car: carList) {
                Validator.forwardOrStop(car);
            }
            printMovingCar(carList);
        }

        endGame(carList);
    }

    private void endGame(List<Car> carList) {
        List<String> carNames = raceWinner.findCarNames(carList);

        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", carNames));
    }

    private void printMovingCar(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + printDash(car));
        }
        System.out.println();
    }

    private String printDash(Car car) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < car.getPosition(); i++) {
            result.append(dash);
        }

        return result.toString();
    }
}

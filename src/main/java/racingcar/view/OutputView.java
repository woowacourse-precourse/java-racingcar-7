package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    public void printMoveResultMessage() {
        System.out.println("실행 결과");
    }

    public void printMovedCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getMovedNumber(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public void printWinner(List<String> winners) {
        System.out.print("최종 우승자 : ");
        String winnerNames = String.join(", ", winners);
        System.out.println(winnerNames);
    }
}

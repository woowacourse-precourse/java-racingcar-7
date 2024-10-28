package racingcar.io;

import java.util.List;
import racingcar.car.Car;

public class Output {
    public void printResult() {
        System.out.println("\n실행 결과");
    }

    public void printCar(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printMoveByOrder(car);
        }
        System.out.println();
    }

    public void printMoveByOrder(Car car) {
        for (int i = 0; i < car.getTotalMove(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printChampion(List<String> champions) {
        System.out.println("최종 우승자 : " + String.join(", ", champions));
    }
}

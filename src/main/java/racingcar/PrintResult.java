package racingcar;

import java.util.List;

public class PrintResult {

    public void printCar(Car car) {
        System.out.print(car.getCarName() + " : ");
        for (int i = 1; i <= car.getForwardCount(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printWinner(List<String> carName) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", carName));
    }
}

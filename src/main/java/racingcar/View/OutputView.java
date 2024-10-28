package racingcar.View;

import racingcar.Model.Car;

import java.util.ArrayList;

public class OutputView {

    public static void PrintResult(ArrayList<Car> cars) {
        System.out.println("실행 결과");

        for (Car car : cars) {
            System.out.println(car.printResult());
        }
        System.out.println();
    }

    public static void PrintWinner(ArrayList<Car> winners) {
        System.out.print("최종 우승자 : ");

        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}

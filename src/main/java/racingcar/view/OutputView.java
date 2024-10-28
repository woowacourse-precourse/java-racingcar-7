package racingcar.view;

import racingcar.domain.Car;

import java.util.ArrayList;

public class OutputView {

    public static void printResultFormatPerOneRace() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printResultPerOneRace(Car[] cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();

    }

    public static void printResultFinal(ArrayList<Car> winners) {
        System.out.print("최종 우승자 : ");
        System.out.print(winners.getFirst().getName());

        if (winners.size() > 1) {
            for (int i = 1; i < winners.size(); i++) {
                System.out.print(", " + winners.get(i).getName());
            }
        }
    }
}

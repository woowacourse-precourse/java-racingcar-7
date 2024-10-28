package racingcar;

import java.util.List;

public class Printer {

    public static void displayResult(List<Car> cars, int tryCounts) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < tryCounts; i++) {
            displayMovement(cars);
        }
        displayWinner(Winner.find(cars));
    }

    public static void displayMovement(List<Car> cars) {
        for (Car car : cars) {
            car.move();
            System.out.println(car.name + " : " + displayDistance(car));
        }
        System.out.println();
    }

    public static String displayDistance(Car car) {
        String distance = "";
        for (int i = 0; i < car.distance; i++) {
            distance = distance.concat("-");
        }
        return distance;
    }

    public static void displayWinner(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        Car singleWinner = winners.getFirst();

        if (winners.size() == 1) {
            System.out.print(singleWinner.name);
            return;
        }
        System.out.println(Winner.createList(winners));
    }
}

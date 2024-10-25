package racingcar;

import java.util.List;

public class Output {

    public static void printResult(List<Car> cars, int tryCounts) {
        System.out.println("실행 결과");
        for (int i = 0; i < tryCounts; i++) {
            printMovement(cars);
        }
        printWinner(Winner.find(cars));
    }

    public static void printMovement(List<Car> cars) {
        for (Car car : cars) {
            car.drive();
            System.out.println(car.name + " : " + displayDistance(car));
        }
        System.out.println();
    }

    public static String displayDistance(Car car) {
        String distance = "";
        for (int i = 0; i < car.distance; i++) {
            distance += "-";
        }
        return distance;
    }

    public static void printWinner(List<Car> winners) {
        System.out.print("최종 우승자 : ");

        if (winners.size() == 1) {
            System.out.print(winners.getFirst().name);
            return;
        }

        System.out.println(Winner.makeList(winners));
    }
}

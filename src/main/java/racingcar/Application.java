package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        String input = Console.readLine();
        List<Car> cars = new ArrayList<>();
        String[] carNames = input.split(",");
        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }

        int T = Integer.parseInt(Console.readLine());
        for (int i = 0; i < T; i++) {
            for (Car car : cars) {
                car.move();
            }
            printRaceResult(cars);
        }
    }

    public static void printRaceResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

}

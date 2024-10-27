package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();
        List<Car> cars = makeCars(input);
        int stage = setStage(Console.readLine());
    }

    public static List<Car> makeCars(String input) {
        List<Car> cars = new ArrayList<>();
        String[] carNames = input.split(",");

        for (String name : carNames) {
            String trimmedName = name.trim();
            if (trimmedName.length() > 5) {
                throw new IllegalArgumentException();
            }
            cars.add(new Car(name.trim()));
        }

        return cars;
    }

    public static int setStage(String input) {
        try {
            int stage = Integer.parseInt(input);

            if (stage < 1) {
                throw new IllegalArgumentException();
            }

            return stage;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}




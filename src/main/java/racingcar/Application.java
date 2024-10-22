package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    static List<Car> cars;

    static class Car {
        String name;
        int moveCount;

        public Car(String name) {
            this.name = name;
            moveCount = 0;
        }

        @Override
        public String toString() {
            return name + " : " + "-".repeat(moveCount) + "\n";
        }
    }

    private static void run() {

        inputCars();
        inputPlayCount();

    }

    private static void inputPlayCount() {
        print("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
    }

    private static void inputCars() {
        print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carsInput = Console.readLine();

        List<String> names = getCompactNames(carsInput);
        cars = new ArrayList<>();
        if (isValidNames(names))
            for (String name : names) cars.add(new Car(name));

    }

    private static boolean isValidNames(List<String> names) {
        if (names.size() > 20) throw new IllegalArgumentException("자동차 이름은 20개 이하로 입력하세요.");

        for (String name : names) {
            if (name.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력하세요.");
        }

        return true;
    }

    private static List<String> getCompactNames(String namesInput) {
        List<String> names = new ArrayList<>();
        for (String name : namesInput.split(",")) {
            String compactName = name.trim();
            if (!compactName.isEmpty()) names.add(compactName);
        }

        return names;
    }

    private static void print(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {

        run();

    }
}

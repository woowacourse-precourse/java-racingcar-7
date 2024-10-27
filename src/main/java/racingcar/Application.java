package racingcar;
import camp.nextstep.edu.missionutils.Console;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        validateEndofInput(names);
        List<Car> cars = createCars(names);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String count = Console.readLine();
        int trial = isPositive(count);

        Race race = new Race(cars, trial);
        race.start();
    }
    public static List<Car> createCars(String names) {
        String[] carNames = names.split(",");
        List<Car> cars = new ArrayList<>();
        Set<String> carNameSet = new HashSet<>();
        for (String carName : carNames) {
            validateDuplicate(carNameSet, carName);
            validateEmpty(carName);
            validateLength(carName);
            cars.add(new Car(carName));
        }
        return cars;
    }
    public static int isPositive(String count) {
        int trial = validateInteger(count);
        if (trial < 0) {
            throw new IllegalArgumentException();
        }
        return trial;
    }
    public static void validateDuplicate(Set<String> set, String name) {
        if (!set.add(name)) {
            throw new IllegalArgumentException();
        }
    }
    public static void validateEndofInput(String names) {
        if (!Character.isAlphabetic(names.charAt(names.length() - 1))) {
            throw new IllegalArgumentException();
        }
    }
    public static void validateEmpty(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
    public static void validateLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
    public static int validateInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}

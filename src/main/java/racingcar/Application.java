package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        final String[] names = getInputName();
        final int inputCount = getInputCount();

        final List<Car> cars = createCars(names);

        runRace(inputCount, cars);

        printWinner(cars);
    }

    static class Car {
        String name;
        int advance;

        Car(String name) {
            this.name = name;
            this.advance = 0;
        }
    }

    private static String[] getInputName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputName = Console.readLine();

        validateInputEmpty(inputName);

        final String[] names = splitDelimiter(inputName);

        validateCarNames(names);

        validateNameLength(names);

        return names;
    }

    public static void validateInputEmpty(String inputName) {
        if (inputName == null || inputName.isEmpty()) {
            throw new IllegalArgumentException("내용을 입력해주세요.");
        }
    }

    private static String[] splitDelimiter(String inputName) {
        return inputName.split(",");
    }

    private static void validateCarNames(String[] names) {
        for (String name : names) {
            if (name.isEmpty()) {
                throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
            }
        }
    }

    private static void validateNameLength(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private static int getInputCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();

        validateInputEmpty(input);

        return validateInputInteger(input);
    }

    private static int validateInputInteger(String input) {
        int inputCount;

        try {
            inputCount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }

        if (inputCount <= 0) {
            throw new IllegalArgumentException("1 이상의 양의 정수만 입력해주세요.");
        }

        return inputCount;
    }

    private static List<Car> createCars(String[] names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
        return cars;
    }

    private static void runRace(int inputCount, List<Car> cars) {
        System.out.println("실행 결과");
        for (int i = 0; i < inputCount; i++) {
            updateCarsAdvance(cars);

            printCarsPosition(cars);
        }
    }

    private static void printCarsPosition(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.name + " : " + "-".repeat(car.advance));
        }
        System.out.println();
    }

    private static void updateCarsAdvance(List<Car> cars) {
        for (Car car : cars) {
            int randomNum = Randoms.pickNumberInRange(0, 9);

            if (randomNum > 3) {
                car.advance += 1;
            }
        }
    }

    private static void printWinner(List<Car> cars) {
        final List<Integer> advances = getAdvances(cars);
        final List<String> winner = getWinner(cars, advances);

        System.out.println("최종 우승자 : " + String.join(", ", winner));
    }

    private static List<Integer> getAdvances(List<Car> cars) {
        List<Integer> advances = new ArrayList<>();

        for (Car car : cars) {
            advances.add(car.advance);
        }
        return advances;
    }

    private static List<String> getWinner(List<Car> cars, List<Integer> advances) {
        List<String> winner = new ArrayList<>();
        int maxAdvance = Collections.max(advances);

        for (Car car : cars) {
            if (car.advance == maxAdvance) {
                winner.add(car.name);
            }
        }
        return winner;
    }

}

package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    static final int STANDARD = 4;
    static List<Car> cars;
    static List<String> winners;
    static int playCount;
    static int winnerScore;

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
        play();
        outputWinner();
    }

    private static void outputWinner() {
        winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.moveCount == winnerScore) winners.add(car.name);
        }

        String output = String.join(",", winners);
        print(output);
    }

    private static void play() {
        print("\n실행 결과");
        for (int i = 0; i < playCount; i++) {
            playOnce();
        }
    }

    private static void playOnce() {
        for (Car car : cars) {
            if (canGo()) winnerScore = Math.max(winnerScore, ++car.moveCount);
            print(car.toString());
        }
        print("");
    }

    private static boolean canGo() {
        int randomNumbers = Randoms.pickNumberInRange(0, 9);
        return randomNumbers >= STANDARD;
    }

    private static void inputPlayCount() {
        print("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        if (isValidInput(input)) playCount = Integer.parseInt(input);
        if (playCount > 30) throw new IllegalArgumentException("시도 횟수는 30이하로 입력하세요.");
    }

    private static boolean isValidInput(String input) {
        if (!input.matches("\\d+")) throw new IllegalArgumentException("숫자만 입력하세요.");
        return true;
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

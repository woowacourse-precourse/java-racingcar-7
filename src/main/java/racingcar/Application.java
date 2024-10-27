package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<Car> cars = makeCars(Console.readLine());

        System.out.println("시도할 횟수는 몇 회인가요?");
        int stage = setStage(Console.readLine());

        System.out.println("\n실행결과");
        for (int currentStage = 1; currentStage <= stage; currentStage++) {
            cars.forEach(car -> {
                car.move(Randoms.pickNumberInRange(0, 9));
            });
            printCurrentStage(cars);
        }

        System.out.printf("최종 우승자 : %s", getWinners(cars));
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

    public static void printCurrentStage(List<Car> cars) {
        cars.forEach(car -> {
            System.out.printf("%s : %s\n", car.getName(), "-".repeat(car.getStep()));
        });
        System.out.println();
    }

    public static String getWinners(List<Car> cars) {
        int maxStep = cars.stream()
                .mapToInt(Car::getStep)
                .max()
                .orElse(0);

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getStep() == maxStep) {
                winners.add(car.getName());
            }
        }

        return String.join(", ", winners);
    }
}




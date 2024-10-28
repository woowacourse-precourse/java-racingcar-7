package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        getInput();
    }

    private static void getInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        String[] carNames = carNamesInput.split(",");
        validateCarNames(carNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String attemptsInput = Console.readLine();
        int attempts = Integer.parseInt(attemptsInput);
        validateAttempts(attempts);

        List<Car> cars = createCars(carNames);
        runRace(cars, attempts);
        printResults(cars);  // 경주 후 결과 출력

        String winners = determineWinners(cars); // 우승자 결정
        System.out.println("우승자: " + winners);
    }

    private static List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private static void runRace(List<Car> cars, int attempts) {
        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                car.move();
                printCarPosition(car);
            }
            System.out.println();
        }
    }

    private static void printCarPosition(Car car) {
        System.out.print(car.getName() + ": ");
        System.out.println("-".repeat(car.getPosition()));
    }

    private static void printResults(List<Car> cars) {
        System.out.println("최종 결과:");
        for (Car car : cars) {
            System.out.println(car.getName() + ": " + "-".repeat(car.getPosition()));
        }
    }

    private static String determineWinners(List<Car> cars) {
        int maxPosition = 0;
        List<String> winners = new ArrayList<>();

        // 가장 멀리 간 자동차의 위치 찾기
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        // 우승자 이름 찾기
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return String.join(", ", winners);
    }

    private static void validateCarNames(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다.");
            }
        }
    }

    private static void validateAttempts(int attempts) {
        if (attempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
        }
    }
}

class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        int randomValue = Randoms.pickNumberInRange(0,9); // 0~9 랜덤 값 생성
        if (randomValue >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}

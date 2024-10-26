package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    public void moveOnePosition() {
        position++;
    }
    public String getCarName() {
        return name;
    }
    public int getCarPosition() {
        return position;
    }
}

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = new ArrayList<>();
        carNames = getCarNames();

        isValidCarNames(carNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        int totalRaceCount = 0;
        totalRaceCount = getTotalRaceCount();

        List<Car> cars = createCars(carNames);

        playRaceInTotalCounts(cars, totalRaceCount);

    }

    public static List<String> getCarNames(){
        String input = Console.readLine();
        // 입력된 문자열을 쉼표로 분리하고, 빈 문자열을 필터링하여 유효한 이름만 리스트에 추가
        return Arrays.stream(input.split(","))
                .map(String::trim) // 공백 제거
                .filter(name -> !name.isEmpty()) // 빈 문자열 필터링
                .toList();
    }

    public static int getTotalRaceCount(){
        String input = Console.readLine();
        isValidTotalRaceCount(input);
        return Integer.parseInt(input);
    }

    public static void isValidCarNames(List<String> carNames) {
        if (carNames == null || carNames.isEmpty() || carNames.stream().allMatch(String::isEmpty)) {
            throw new IllegalArgumentException();
        }

        // 중복된 이름이 있는지 확인
        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() != carNames.size()) {
            throw new IllegalArgumentException();
        }

        for (String name : carNames) {
            if (name.length() > 5 || name.isEmpty()) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void isValidTotalRaceCount(String input) {
        if (!input.matches("-?\\d+")) {
            throw new IllegalArgumentException();
        }

        int raceCount = Integer.parseInt(input);

        if (raceCount <= 0) {
            throw new IllegalArgumentException();
        }
    }

    // 자동차 생성
    public static List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public static void playRaceInTotalCounts(List<Car> cars, int totalRaceCount) {
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < totalRaceCount; i++) {
            moveAllOfCars(cars);
            printEachRaceResult(cars);
        }
    }

    public static void moveAllOfCars(List<Car> cars) {
        for (Car car : cars) {
            moveCar(car);
        }
    }

    public static void moveCar(Car car) {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        if (randomValue >= 4) {
            car.moveOnePosition();
        }
    }

    private static void printEachRaceResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getCarName() + " : ");
            for (int i = 0; i < car.getCarPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
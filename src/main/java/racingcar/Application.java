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
        List<String> carNames = inputCarNames();
        int totalRaceCount = inputRaceCount();

        List<Car> cars = createCars(carNames);
        playRaceInTotalCounts(cars, totalRaceCount);

        List<String> winners = findWinners(cars);
        printWinners(winners);
    }

    public static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = getCarNames();
        isValidCarNames(carNames);
        return carNames;
    }

    public static int inputRaceCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int totalRaceCount = getTotalRaceCount();
        isValidTotalRaceCount(Integer.toString(totalRaceCount));
        return totalRaceCount;
    }

    public static List<String> getCarNames(){
        String input = Console.readLine();
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
        return carNames.stream()
                .map(Car::new)
                .toList();
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

    public static void printEachRaceResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getCarName() + " : ");
            StringBuilder positionDisplay = new StringBuilder();
            for (int i = 0; i < car.getCarPosition(); i++) {
                positionDisplay.append("-");
            }
            System.out.println(positionDisplay);
        }
        System.out.println();
    }


    public static List<String> findWinners(List<Car> cars) {
        final int maxPosition = findMaxPosition(cars);
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getCarPosition() == maxPosition) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }

    public static int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getCarPosition() > maxPosition) {
                maxPosition = car.getCarPosition();
            }
        }
        return maxPosition;
    }

    public static void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }

}
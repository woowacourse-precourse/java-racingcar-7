package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        List<String> carNames = List.of(carName.split(",")).stream().map(String::trim).collect(Collectors.toList());

        System.out.println("시도할 횟수는 몇 회인가요?");
        int round = Integer.parseInt(Console.readLine());

        RacingGame game = new RacingGame(carNames, round);
        game.start();
    }
}

class RacingGame {
    private final List<Car> cars;
    private final int round;

    public RacingGame(List<String> carNames, int round) {
        validateCarNames(carNames);
        validateRound(round);

        this.cars = duplicateNames(carNames).stream().map(Car::new).collect(Collectors.toList());
        this.round = round;
    }

    private List<String> duplicateNames(List<String> carNames) {
        Map<String, Integer> nameCount = new HashMap<>();

        for (String name : carNames) {
            nameCount.put(name, nameCount.getOrDefault(name, 0) + 1);
        }

        // 이름 리스트를 순회하면서 중복된 이름에만 숫자 접미사를 붙인다.
        List<String> uniqueNames = new ArrayList<>();
        Map<String, Integer> suffixCount = new HashMap<>();

        for (String name : carNames) {
            if (nameCount.get(name) > 1) {
                // 중복된 이름일 경우 숫자 접미사 추가
                int suffix = suffixCount.getOrDefault(name, 1);
                uniqueNames.add(name + suffix);
                suffixCount.put(name, suffix + 1);
            } else {
                // 고유한 이름은 그대로 추가
                uniqueNames.add(name);
            }
        }
        return uniqueNames;
    }


    private void validateCarNames(List<String> carNames) {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException("자동차 이름은 최소 2개 이상 입력해야 합니다.");
        }
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
            if (name.matches(".*\\d.*")) {
                throw new IllegalArgumentException("자동차 이름에는 숫자를 포함할 수 없습니다.");
            }
        }
    }

    private void validateRound(int round) {
        if (round < 1) {
            throw new IllegalArgumentException("1 이상의 정수여야 합니다.");
        }
    }

    public void start() {
        for (int i = 0; i < round; i++) {
            race();
            printStatus();
        }
        // 승자 출력
        printWinner();
    }

    private void race() {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.move();
            }
        }
    }

    private void printStatus() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getPositionString());
        }
        System.out.println();
    }

    private void printWinner() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
        System.out.println("최종 우승자 : " + String.join(", ", winners));
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
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getPositionString() {
        return "-".repeat(position);
    }
}

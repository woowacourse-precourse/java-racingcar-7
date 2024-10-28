package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String carNamesInput = getCarNames();
        int moveCount = getMoveCount();
        List<Car> cars = createCars(carNamesInput);

        for (int i = 0; i < moveCount; i++) {
            playRound(cars);
            printRoundResult(cars);
        }

        printWinners(cars);  // 최종 우승자 출력
    }

    private static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        // 입력 유효성 검증
        String[] carNames = input.split(",");
        for (String name : carNames) {
            if (name.trim().isEmpty() || name.trim().length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
            }
        }
        return input;
    }

    private static int getMoveCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();

        try {
            int moveCount = Integer.parseInt(input);
            if (moveCount <= 0) {
                throw new IllegalArgumentException("이동 횟수는 양의 정수여야 합니다.");
            }
            return moveCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("이동 횟수는 정수로 입력해야 합니다.");
        }
    }

    private static List<Car> createCars(String carNamesInput) {
        String[] carNames = carNamesInput.split(",");
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

    private static void playRound(List<Car> cars) {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            if (randomValue >= 4) {
                car.move();
            }
        }
    }

    private static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            System.out.println("-".repeat(car.getPosition()));
        }
        System.out.println();  // 라운드 종료 후 한 줄 띄움
    }

    private static void printWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);  // 최대 위치 찾기

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));  // 우승자 출력
    }

    // Car 중첩 클래스
    private static class Car {
        private final String name;
        private int position = 0;

        public Car(String name) {
            if (name.length() > 5 || name.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
            }
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getPosition() {
            return position;
        }

        public void move() {
            position++;
        }
    }
}

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 자동차 경주 게임 시작
        RacingGame racingGame = new RacingGame();
        racingGame.start();
    }
}

class RacingGame {
    private static final int MINIMUM_ADVANCE_CONDITION = 4;
    private List<Car> cars = new ArrayList<>();

    public void start() {
        // 1. 사용자로부터 자동차 이름 입력
        String carNamesInput = inputCarNames();
        createCars(carNamesInput);

        // 2. 사용자로부터 시도 횟수 입력
        int numberOfRounds = inputNumberOfRounds();

        // 3. 시도 횟수만큼 경주 진행
        for (int i = 0; i < numberOfRounds; i++) {
            raceCars();
            printRaceResult();
        }

        // 4. 우승자 출력
        announceWinners();
    }

    private String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private int inputNumberOfRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    private void createCars(String carNamesInput) {
        String[] carNames = carNamesInput.split(",");
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            cars.add(new Car(name.trim()));
        }
    }

    private void raceCars() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            if (randomValue >= MINIMUM_ADVANCE_CONDITION) {
                car.advance();
            }
        }
    }

    private void printRaceResult() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getPositionString());
        }
        System.out.println();
    }

    private void announceWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
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

    public void advance() {
        this.position++;
    }

    public String getPositionString() {
        return "-".repeat(position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}

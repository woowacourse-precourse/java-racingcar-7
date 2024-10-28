package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {

    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GAME_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String GAME_RESULT = "\n실행 결과";
    private static final String FINAL_WINNER = "최종 우승자 : ";
    private static final String ERROR_MESSAGE_NAME = "이름은 5자 이하로 입력해야 합니다.";
    private static final String ERROR_MESSAGE_COUNT = "1 이상의 숫자만 입력할 수 있습니다.";

    public void start() {
        System.out.println(START_MESSAGE);
        String names = readLine();
        List<Car> cars = Stream.of(names.split(",")).map(name -> new Car(name.trim(), 0)).collect(Collectors.toList());
        nameCheck(cars);
        System.out.println(GAME_COUNT_MESSAGE);
        int count = countCheck(readLine());
        System.out.println(GAME_RESULT);
        findMovingCar(cars);
        for (int i = 0; i < count; i++) {
            printGameResult(cars);
        }
        printWinner(cars);
    }

    public void nameCheck(List<Car> cars) {
        for (Car car : cars) {
            if (car.getName().length() > 5) {
                throw new IllegalArgumentException(ERROR_MESSAGE_NAME);
            }
        }
    }

    public int countCheck(String input) {
        int num = 0;
        try {
            num = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_COUNT);
        }
        if (num < 1) {
            throw new IllegalArgumentException(ERROR_MESSAGE_COUNT);
        }
        return num;
    }

    private List<Car> findMovingCar(List<Car> cars) {
        return cars.stream().map(car -> {
            car.move(randomNumberPick());
            return car;
        }).collect(Collectors.toList());
    }

    private int randomNumberPick() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private void printGameResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        System.out.println();
    }

    public void printWinner(List<Car> cars) {
        Car winner = cars.stream().max(Comparator.comparingInt(Car::getDistance)).get();
        List<String> winners = cars.stream().filter(c -> c.getDistance() >= winner.getDistance()).map(c -> c.getName())
                .collect(Collectors.toList());
        System.out.print(FINAL_WINNER + String.join(", ", winners));
    }
}

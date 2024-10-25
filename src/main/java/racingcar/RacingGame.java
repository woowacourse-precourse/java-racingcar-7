package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {

    private static String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static String GAME_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static String GAME_RESULT = "\n실행 결과";
    private static String FINAL_WINNER = "\n최종 우승자 : ";

    public void start() {
        System.out.println(START_MESSAGE);
        String names = readLine();
        List<Car> cars = Stream.of(names.split(",")).map(name -> new Car(name.trim(), 0)).collect(Collectors.toList());
        nameCheck(cars);
        System.out.println(GAME_COUNT_MESSAGE);
        int count = Integer.parseInt(readLine());
        System.out.println(GAME_RESULT);
        findMovingCar(cars);
        for (int i = 0; i < count; i++) {
            printGameResult(cars);
        }
        getWinner(cars);
    }

    public void nameCheck(List<Car> cars) {
        for (Car car : cars) {
            if (car.getName().length() > 5) {
                throw new IllegalArgumentException();
            }
        }
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

    private void getWinner(List<Car> cars) {
        Car winner = cars.stream().max(Comparator.comparingInt(Car::getDistance)).get();
        List<String> winners = cars.stream().filter(c -> c.getDistance() >= winner.getDistance()).map(c -> c.getName())
                .collect(Collectors.toList());
        System.out.println(FINAL_WINNER + String.join(", ", winners));
    }
}

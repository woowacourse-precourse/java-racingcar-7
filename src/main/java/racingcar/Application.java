package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.MyException.INVALID_MOVE_COUNT;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import racingcar.car.Car;
import racingcar.car.RandomCar;

public class Application {
    private Cars cars;

    public Application() {
        this.cars = new Cars();
    }

    public static void main(String[] args) {
        Application racingGame = new Application();
        racingGame.registerCars(RandomCar::new);
        racingGame.playGame();
        racingGame.printWinner();
    }

    public void registerCars(Function<String, Car> factory) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = List.of(readLine().split(","));
        cars = new Cars(carNames, factory);
        System.out.println();
    }

    public void playGame() {
        int moveCount = getMoveCount();

        System.out.println("실행 결과");
        for (int i = 0; i < moveCount; i++) {
            cars.moveAll();
            System.out.println(cars);
            System.out.println();
        }
    }

    public void printWinner() {
        System.out.print("최종 우승자 : ");
        System.out.println(cars.getAllFarthest().stream()
                .map(Car::getName)
                .collect(Collectors.joining(", ")));
    }

    private int getMoveCount() {
        try {
            System.out.println("시도할 횟수는 몇 회인가요?");
            int moveCount = Integer.parseInt(readLine());
            System.out.println();
            return moveCount;
        } catch (NumberFormatException e) {
            throw INVALID_MOVE_COUNT.getException();
        }
    }
}

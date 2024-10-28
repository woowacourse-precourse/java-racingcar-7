package racingcar;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        RacingCarInput car = new RacingCarInput();
        RacingCarOutput output = new RacingCarOutput();
        List<String> carNames = car.getCarNames();

        try {
            List<Car> cars = carNames.stream().map(Car::new).toList();
            int count = car.getCount();

            Game game = new Game(cars, count);
            game.startRace();

            List<String> winners = game.getFinalWinners();
            output.printFinalWinners(winners);
        } catch (IllegalArgumentException e) {
            // 잘못된 값을 입력하는 예외가 발생한 경우, 애플리케이션 종료시킴
            System.out.println("잘못된 입력 : " + e.getMessage());
        }
    }
}

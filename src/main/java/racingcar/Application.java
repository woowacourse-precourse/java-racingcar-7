package racingcar;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        String[] carNames = inputView.inputCarNames().split(",");
        int raceRound = inputView.inputRaceRound();

        List<Car> cars = Arrays.stream(carNames).map(Car::new).toList();

        System.out.println();
        System.out.println("실행결과");
        while (raceRound-- > 0) {
            cars.forEach(Car::move);
            cars.forEach(car -> {
                StringBuilder sb = new StringBuilder(car.getName() + " : ");
                int distance = car.getDistance();
                while (distance-- > 0) {
                    sb.append("-");
                }
                System.out.println(sb);
            });
            System.out.println();
        }


    }
}

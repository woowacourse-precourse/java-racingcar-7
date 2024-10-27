package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGameService {

    public RacingGame initializeGame(String inputNames) {
        List<String> carNames = Arrays.asList(inputNames.split(","));
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {

            if(name.length() > 5){
                throw new IllegalArgumentException("자동차 이름은 5자 이하입니다.");
            }
            cars.add(new Car(name));
        }
        return new RacingGame(cars);
    }

    public void startRace(RacingGame racingGame, int tryCount) {
        System.out.println("\n실행 결과");
        List<Car> cars = racingGame.getCars();

        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                if (Randoms.pickNumberInRange(0, 9) >= 4) {
                    car.move();
                }
                System.out.println(car);
            }
            System.out.println();
        }
    }
}

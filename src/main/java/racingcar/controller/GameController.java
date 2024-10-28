package racingcar.controller;

import racingcar.exception.*;
import racingcar.model.Car;
import racingcar.view.InputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class GameController {

    private List<Car> cars;
    private InputView inputView;

    public GameController(InputView inputView) {
        this.inputView = inputView;
        cars = new ArrayList<>();
    }

    public void startGame() {
        String inputCarsName = inputView.getInput();
        String[] splitCar = inputCarsName.split(",");

        for (String s : splitCar) {
            s = s.trim();
            if (s.isEmpty()) {
                throw new BlankException();
            }
            if (s.length() > 5) {
                throw new BlankException();
            }
            cars.add(new Car(s));
        }

        HashSet<String> set = new HashSet<>(List.of(splitCar));
        if (splitCar.length != set.size()) {
            throw new DuplicateException();
        }

        String tryCount = inputView.getTryCount();
        if (tryCount.isEmpty()) {
            throw new BlankException();
        }
        if (!tryCount.matches("[+-]?\\d*(\\d+)?")) {
            throw new NotNumberException();
        }
        if (Integer.parseInt(tryCount) <= 0) {
            throw new NegativeNumberException();
        }

        int count = Integer.parseInt(tryCount);
        System.out.println("실행 결과");
        while (count > 0) {
            for (Car car : cars) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if (randomNumber >= 4) {
                    car.moveCarPosition();
                }

                System.out.println(car.getName() + " : " + car.getCurrentPosition());
            }
            count-=1;
            System.out.println();
        }

        List<String> winner = new ArrayList<>();
        int winScore = 0;
        for (Car car : cars) {
            int score = car.getPosition();
            if (score > winScore) {
                winScore = score;
                winner.clear();
                winner.add(car.getName());
            } else if (score == winScore) {
                winner.add(car.getName());
            }
        }

        System.out.println("최종 우승자: " + String.join(",", winner));

    }
}

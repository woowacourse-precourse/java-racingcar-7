package racingcar;

// 입력, 실행, 출력을 담당함

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void gameStart() {
        List<Car> cars = input();
        int tryCount = inputView.inputTryCount();

        playGame(cars, tryCount);
        findWinner(cars);
    }

    public List<Car> input() {
        List<String> carNames = inputView.inputCarName();
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }

    public void playGame(List<Car> cars, int tryCount) {
        System.out.println(System.lineSeparator() + "실행 결과");
        for (int round = 1; round <= tryCount; round++) {
            for (Car car : cars) {
                int num = Randoms.pickNumberInRange(0, 9);
                if (num >= 4) {
                    car.moveForward();
                }
                String dash = "-".repeat(car.getPosition());
                System.out.println(car.getName() + " : " + dash);
                // outputView.printRoundResult(cars);
            }
            System.out.println();
        }
    }

    public void findWinner(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        outputView.printWinners((winners));
    }
}

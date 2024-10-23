package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.RandomNumber;
import racingcar.util.StringParser;
import racingcar.view.InputView;

public class Game {

    private List<Car> cars;
    private int moveNumber;

    public void startGame() {
        readCarsData();
        readMoveNumberData();
    }

    public void doGame() {
        while (moveNumber > 0) {
            move();
            moveNumber--;
        }
    }

    public void move() {
        for (int i = 0; i < cars.size(); i++) {
            if (RandomNumber.createRandomNumber() >= 4) {
                getCars().get(i).move();
            }
        }
    }

    private void readCarsData() {
        InputView.printCarInputMessage();
        List<String> names = StringParser.parseCarName(InputView.readCars());
        this.cars = names.stream().map(Car::new).collect(Collectors.toList());
    }

    private void readMoveNumberData() {
        InputView.printMoveInputMessage();
        this.moveNumber = InputView.readMoveNumber();
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMoveNumber() {
        return moveNumber;
    }
}

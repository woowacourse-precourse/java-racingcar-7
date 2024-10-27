package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.model.Car;
import racingcar.model.SplitCar;
import racingcar.model.Turn;
import racingcar.model.FindWinner;
import racingcar.view.InputCarName;
import racingcar.view.InputTurn;
import racingcar.view.Output;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    final int MAX_NAME_LENGTH = 5;

    private final List<Car> carList;
    private int playTurn;

    public RacingCar() {
        this.carList = new ArrayList<>();

        InputCarName inputCarName = new InputCarName();
        SplitCar splitCar = new SplitCar(inputCarName.getCarName());
        InputTurn inputTurn = new InputTurn();
        Turn turn = new Turn(inputTurn.getTurn());

        List<String> carNames = splitCar.getSplitCarNames();
        for (String carName : carNames) {
            if (carName.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException();
            }
            Car car = new Car(carName);
            this.carList.add(car);
        }

        this.playTurn = turn.getTurn();
    }

    private void carMoving() {
        for (Car car : carList) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    public void playRacing() {
        Output output = new Output();
        FindWinner findWinner = new FindWinner();

        System.out.println("\n실행 결과");
        for (int nowTurn = 0; nowTurn < playTurn; nowTurn++) {
            carMoving();
            output.printCarLocation(carList);
        }

        output.printWinner(findWinner.winnersMember(carList));
    }
}
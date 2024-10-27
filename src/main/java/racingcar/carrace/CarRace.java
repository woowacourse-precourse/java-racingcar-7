package racingcar.carrace;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.model.Car;
import racingcar.utils.Parser;
import racingcar.view.OutputView;

public class CarRace {
    private final List<Car> carList;
    private int remainNum;

    public CarRace(String cars, int num) {
        carList = Parser.parseCarList(cars);
        remainNum = num;
    }

    public void startRace() {
        while (remainNum > 0) {
            moveCar();
            OutputView.printResult(createOutputMessage());
            remainNum--;
        }
    }

    private String createOutputMessage() {
        StringBuilder sb = new StringBuilder();

        for (Car car : carList) {
            sb.append(car.getName());
            sb.append(" : ");
            sb.append("-".repeat(car.getDistance()));
            sb.append("\n");
        }

        return sb.toString();
    }

    private void moveCar() {
        for (Car car : carList) {
            if (getRandomNumber() >= 4) {
                car.move();
            }
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }


}

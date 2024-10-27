package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import racingcar.model.Car;
import racingcar.utils.Parser;
import racingcar.view.OutputView;

public class CarRace {
    private final List<Car> carList;
    private int remainNum;

    public CarRace(String cars, String num) {
        carList = Parser.parseCarList(cars);
        remainNum = Parser.parseNum(num);
    }

    public void startRace() {
        while (remainNum > 0) {
            moveCar();
            OutputView.printResult(createOutputMessage());
            remainNum--;
        }
        OutputView.printResult(createWinnerMessage());
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

    private String createWinnerMessage() {
        StringBuilder sb = new StringBuilder("최종 우승자 : ");
        int winnerCnt = getWinnerCnt();
        for (Car car : carList) {
            if (winnerCnt == 0) {
                break;
            }
            sb.append(car.getName()).append(", ");
            winnerCnt--;
        }
        return sb.toString();
    }

    private int getWinnerCnt() {
        carList.sort(Comparator.comparingInt(Car::getDistance).reversed());
        int cnt = 0;
        int maxDistance = carList.getFirst().getDistance();
        for (Car car : carList) {
            if (car.getDistance() != maxDistance) {
                return cnt;
            }
            cnt++;
        }
        return cnt;
    }
}

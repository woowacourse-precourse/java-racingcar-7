package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class GamePhase {
    List<Car> carList;
    List<String> winners;
    int maxDistance = 0;
    static final int CONDITION_TO_MOVE = 4;

    public void registerList(List<Car> carList) {
        this.carList = carList;
        this.winners = new ArrayList<>();
    }

    public void advanceTheGamePhase() {
        for(Car car : carList) {
            if(drawNumber() >= CONDITION_TO_MOVE) {
                car.move();
            }
        }

        showGameBoard();
    }

    public void showWinners() {
        for(Car car : carList) {
            checkWinners(car);
        }

        StringBuilder winnersOutput = new StringBuilder();
        while(true) {
            winnersOutput.append(winners.removeFirst());
            if(winners.isEmpty()) {
                break;
            }
            winnersOutput.append(",");
        }

        System.out.println(winnersOutput);
    }

    private int drawNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private void showGameBoard() {
        for(Car car : carList) {
            System.out.println(car.getCurrentDistance());
        }
    }

    private void checkWinners(Car yourCar) {
        int yourDistance = yourCar.getFinalDistance();
        if(yourDistance < maxDistance) {
            return;
        }

        if(yourDistance > maxDistance) {
            winners.clear();
            maxDistance = yourDistance;
        }

        winners.add(yourCar.name);
    }
}

package racingcar.core;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.creator.RacingCarGameCreator;
import racingcar.domain.RacingCar;
import racingcar.runner.Output;

public class RacingCarGame {

    private final Output out = new Output();
    private final List<RacingCar> carList;
    private final int totalRound;

    public RacingCarGame(RacingCarGameCreator creator) {
        this.carList = creator.getCarList();
        this.totalRound = creator.getTotalRound();
    }

    public void start() {
        int round = 0;
        while (round++ < totalRound) {
            raceOneRound();
        }
        printWinners();
    }

    private void raceOneRound() {
        for (RacingCar car : carList) {
            moveOrNot(car);
        }
        out.newLine();
    }

    private void moveOrNot(RacingCar car) {
        if (isMovable()) {
            car.moveForward();
        }
        out.writeln(car);
    }

    private boolean isMovable() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    private void printWinners() {
        out.write("최종 우승자 : ");
        for (RacingCar car : carList) {
            writeIfWinner(car);
        }
        out.printWinner();
    }

    private void writeIfWinner(RacingCar car) {
        if (car.isWinner()) {
            out.writeWinner(car);
        }
    }
}

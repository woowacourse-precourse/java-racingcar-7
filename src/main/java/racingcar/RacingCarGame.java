package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.car.RacingCar;
import racingcar.car.RacingCars;
import racingcar.io.RacingCarIOHandler;

public class RacingCarGame {

    private final RacingCarIOHandler ioHandler = new RacingCarIOHandler();

    public void run() {
        List<String> carNames = ioHandler.askCarNames();
        int round = ioHandler.askRound();

        ioHandler.showExecutionResultMessage();
        RacingCars racingCars = RacingCars.fromNames(carNames);
        playRound(round, racingCars);

        List<String> winnersName = racingCars.getWinnersName();
        ioHandler.showWinners(winnersName);
    }


    private void playRound(int round, RacingCars racingCars) {
        List<RacingCar> cars = racingCars.getCars();
        for (int i = 0; i < round; i++) {
            playOneRound(cars);
            ioHandler.showRacingCarsProgress(cars);
        }
    }

    private void playOneRound(List<RacingCar> cars) {
        cars.forEach(car -> {
            int pickedNumber = Randoms.pickNumberInRange(0, 9);
            car.moveIfRandomNumberIsAbove(pickedNumber);
        });
    }
}

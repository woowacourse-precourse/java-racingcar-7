package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.global.enums.PrintMessage;
import racingcar.model.Cars;
import racingcar.model.Race;
import racingcar.view.OutputView;

public class RacingCarService {
    private final OutputView outputView = OutputView.getInstance();

    public void raceStart(Race race) {
        Integer raceCount = race.getRaceCount();
        Cars cars = race.getCars();

        outputView.printMessage(PrintMessage.GAME_MESSAGE);
        for (int count = 0; count < raceCount; count++) {
            move(cars);
            outputView.printGameResult(cars);
        }
    }

    public void move(Cars cars) {
        cars.getCarList().forEach(
                car -> {
                    int random = getRandomNumber();
                    car.increaseDistance(random);
                }
        );
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

}

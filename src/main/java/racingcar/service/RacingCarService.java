package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.global.enums.PrintMessage;
import racingcar.model.Car;
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

        announceWinner(cars);
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

    public void announceWinner(Cars cars) {
        List<String> winnerList = findWinner(cars);

        outputView.printWinner(joinWinnerList(winnerList));
    }

    private List<String> findWinner(Cars cars) {
        Integer maxDistance = 0;
        List<String> carList = new ArrayList<>();

        for (Car car : cars.getCarList()) {
            Integer distance = car.getDistance();
            if (maxDistance < distance) {
                carList.clear();
                maxDistance = distance;
            }
            if (maxDistance.equals(distance)) {
                carList.add(car.getName());
            }
        }
        return carList;
    }

    private String joinWinnerList(List<String> carList) {
        return String.join(", ", carList);
    }

}

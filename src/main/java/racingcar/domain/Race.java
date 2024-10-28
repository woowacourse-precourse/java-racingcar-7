package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.dto.RacingCar;
import racingcar.view.OutputView;

public class Race {

    private final int tryCount;
    private final OutputView outputView;
    private List<RacingCar> racingCarList;

    public Race(int tryCount, CarName cars, OutputView outputView) {
        this.tryCount = tryCount;
        this.outputView = outputView;
        this.racingCarList = initializeRacingCars(cars.getCarNameList());
    }

    private List<RacingCar> initializeRacingCars(List<String> carNames) {
        List<RacingCar> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new RacingCar(carName, ""));
        }
        return cars;
    }

    public void raceStart() {
        outputView.showResult();
        for (int i = 1; i <= tryCount; i++) {
            executeRaceRound(i);
        }
        outputView.printWinner(findWinner());
    }

    private void executeRaceRound(int round) {
//        outputView.printRound(round);
        for (RacingCar racingCar : racingCarList) {
            moveCar(racingCar);
        }
        System.out.println();
    }

    private void moveCar(RacingCar racingCar) {
        if (canMoving()) {
            racingCar.setPosition(racingCar.getPosition() + "-");
            outputView.printRaceResult(racingCar.getName(), racingCar.getPosition());
        }
    }

    private boolean canMoving() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    private int findLongestPosition() {
        return racingCarList.stream()
            .mapToInt(racingCar -> racingCar.getPosition().length())
            .max()
            .orElse(0);
    }

    private String findWinner() {
        List<String> winners = new ArrayList<>();
        int longestPosition = findLongestPosition();
        for (RacingCar racingCar : racingCarList) {
            if (racingCar.getPosition().length() == longestPosition) {
                winners.add(racingCar.getName());
            }
        }
        return String.join(",", winners);
    }
}

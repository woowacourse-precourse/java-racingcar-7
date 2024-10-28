package racingcar.service;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.constants.RacingGameConstants;
import racingcar.model.RacingCar;
import racingcar.view.OutputView;

public class RacingGameService {

    private final List<RacingCar> racingCars;
    private final OutputView outputView;

    public RacingGameService(List<String> carNames, OutputView outputView) {
        this.racingCars = Collections.unmodifiableList(initializeCars(carNames));
        this.outputView = outputView;
    }

    private List<RacingCar> initializeCars(List<String> carNames) {
        return carNames.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    public void startRace(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            executeSingleRaceRound();
        }
    }

    private void executeSingleRaceRound() {
        raceOnce();
        outputView.printRaceResults(racingCars);
    }

    private void raceOnce() {
        racingCars.forEach(this::moveCarIfPossible);
    }

    private void moveCarIfPossible(RacingCar car) {
        if (Randoms.pickNumberInRange(0, 9) >= RacingGameConstants.MOVE_THRESHOLD.getValue()) {
            car.advance();
        }
    }

    public List<RacingCar> findWinners() {
        int maxPosition = findMaxPosition();
        return racingCars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return racingCars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(0);
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}

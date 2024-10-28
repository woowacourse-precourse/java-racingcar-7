package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.RacingCar;
import racingcar.view.GameView;

public class GameService {
    private List<RacingCar> racingCars;
    private int numRounds;
    private final GameView gameView = new GameView();

    public void getCarNames() {
        String inputCarNames = gameView.inputCarNames();
        validateCarNames(inputCarNames);
        createCarList(inputCarNames);
    }

    private void validateCarNames(String inputCarNames) {
        if (inputCarNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해 주세요.");
        }
        String[] carNames = inputCarNames.split(",");
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            if (carName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 비워둘 수 없습니다.");
            }
        }
    }

    private void createCarList(String inputCarNames) {
        racingCars = new ArrayList<>();
        String[] carNames = inputCarNames.split(",");
        for (String carName : carNames) {
            RacingCar racingCar = new RacingCar(carName);
            racingCars.add(racingCar);
        }
    }

    public void getRounds() {
        int inputRounds = gameView.inputRounds();
        validateRounds(inputRounds);
        numRounds = inputRounds;
    }

    private void validateRounds(int inputRounds) {
        if (inputRounds <= 0) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야합니다.");
        }
    }

    public void doGame() {
        while (numRounds > 0) {
            playGameByRound();
            numRounds--;
        }
        getGameResult();
    }

    private void getGameResult() {
        int maxPosition = getMaxPosition(racingCars);
        List<String> winners = determineWinner(racingCars, maxPosition);
        gameView.displayWinner(winners);
    }

    private List<String> determineWinner(List<RacingCar> racingCars, int maxPosition) {
        return racingCars.stream()
            .filter(racingCar -> racingCar.getPosition() == maxPosition)
            .map(RacingCar::getCarName)
            .collect(Collectors.toList());
    }

    private int getMaxPosition(List<RacingCar> racingCars) {
        return racingCars.stream()
            .mapToInt(RacingCar::getPosition)
            .max()
            .orElse(0);
    }

    private void playGameByRound() {
        for (RacingCar racingCar : racingCars) {
            int randomNum = generateCarRandomNum(racingCar);
            determineCarMove(randomNum, racingCar);
        }
        gameView.displayCurrentRound(racingCars);
    }

    private void determineCarMove(int randomNum, RacingCar racingCar) {
        if (randomNum >= 4) {
            racingCar.setPosition(racingCar.getPosition() + 1);
        }
    }

    private int generateCarRandomNum(RacingCar racingCar) {
        return Randoms.pickNumberInRange(0, 9);
    }
}

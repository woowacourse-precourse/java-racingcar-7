package racingcar;

import java.util.Comparator;
import java.util.List;
import racingcar.car.ICar;
import racingcar.display.IOutputDisplay;

public class CarRacingGame {

    private final IOutputDisplay outputDisplay;
    private final List<ICar> carList;
    private final int round;

    public CarRacingGame(IOutputDisplay outputDisplay, List<ICar> carList, int round) {
        this.outputDisplay = outputDisplay;
        this.carList = carList;
        this.round = round;
    }

    public List<ICar> start() {
        checkGameStartEnable();

        outputDisplay.print("실행 결과\n");

        for (int i = 0; i < round; i++) {
            round();
            outputDisplay.printRoundResult(carList);
        }

        List<ICar> winnerList = findWinner();
        outputDisplay.printWinners(winnerList);

        return winnerList;
    }

    private void checkGameStartEnable() {
        if (carList == null || carList.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INSUFFICIENT_MIN_CAR_COUNT.getMessage());
        }
        if (round <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INSUFFICIENT_MIN_ROUND.getMessage());
        }
    }

    private void round() {
        for (ICar car : carList) {
            car.drive();
        }
    }

    private List<ICar> findWinner() {
        // 우승자 찾기
        ICar winnerCar = carList.stream()
                .max(Comparator.comparingInt(ICar::getPosition))
                .orElseThrow(() -> new NullPointerException(ErrorMessage.CAN_NOT_FOUND_WINNER.getMessage()));

        // 공동 우승자 찾기
        return carList.stream()
                .filter(car -> winnerCar.getPosition() == car.getPosition())
                .toList();
    }
}

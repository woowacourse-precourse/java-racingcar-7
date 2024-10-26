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
        if (carList == null || carList.isEmpty()) {
            throw new IllegalArgumentException("1대 이상의 자동차가 경주에 참여해야 합니다.");
        }
        if (round <= 0) {
            throw new IllegalArgumentException("라운드는 1회 이상 진행되어야 합니다");
        }

        this.outputDisplay = outputDisplay;
        this.carList = carList;
        this.round = round;
    }

    public List<ICar> start() {
        outputDisplay.print("실행 결과\n");

        for (int i = 0; i < round; i++) {
            round();
            outputDisplay.printRoundResult(carList);
        }

        List<ICar> winnerList = findWinner();
        outputDisplay.printWinners(winnerList);

        return winnerList;
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
                .orElseThrow(() -> new NullPointerException("우승자를 찾을 수 없음"));

        // 공동 우승자 찾기
        return carList.stream()
                .filter(car -> winnerCar.getPosition() == car.getPosition())
                .toList();
    }
}

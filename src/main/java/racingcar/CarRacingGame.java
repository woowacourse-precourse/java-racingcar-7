package racingcar;

import java.util.ArrayList;
import java.util.List;
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
        int maxPosition = 0;
        List<ICar> winnerList = new ArrayList<>();

        // TODO: 자동차의 개수가 많아진다면 정렬을 이용해 우승자를 찾는게 나을 것 같음.
        // 가장 많이 전진한 차의 위치 찾기
        for (ICar car : carList) {
            if (maxPosition < car.getPosition()) {
                maxPosition = car.getPosition();
            }
        }

        // 우승자 찾기
        for (ICar car : carList) {
            if (maxPosition <= car.getPosition()) {
                winnerList.add(car);
            }
        }

        return winnerList;
    }
}

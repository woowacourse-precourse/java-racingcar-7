package racingcar;

import java.util.List;

public class RacingCar {
    private Cars carList;
    private TrialNumber trialNumber;
    private final String GAME_START_MESSAGE = "실행 결과";
    private final String WINNER_CAR_NAMES_MESSAGE = "최종 우승자 : %s";

    public RacingCar(List<String> carNames, String trialNumber) {
        this.carList = new Cars(carNames);
        this.trialNumber = new TrialNumber(trialNumber);
    }


    private void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }
    public void run() {
        printGameStartMessage();
        while (trialNumber.isTrialLowerThanTrialNumber()) {
            trialNumber.increaseTrial();
            carList.move();
            carList.printCarsStatus();
        }
        printWinner();
    }

    private void printWinner() {
        String winnerCarNames = carList.getWinnersCarName();
        System.out.printf(WINNER_CAR_NAMES_MESSAGE, winnerCarNames);
    }
}

package racingcar;

public class Winner {
    private Cars carList;
    private final String WINNER_CAR_NAMES_MESSAGE = "최종 우승자 : %s";

    public Winner(Cars carList) {
        this.carList = carList;
    }

    public void printWinnerCarNames() {
        String winnerCarNames = carList.getWinnersCarName();
        System.out.printf(WINNER_CAR_NAMES_MESSAGE, winnerCarNames);
    }
}

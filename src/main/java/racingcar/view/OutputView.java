package racingcar.view;

public class OutputView {

    public void printCarRacingResult(String carName, String advanceResult) {
            System.out.println(carName + " : " + advanceResult);
    }

    public void printCarRacingWinner(String carRacingWinners) {
        System.out.println("최종우승자 : " + carRacingWinners);
    }

    public void printLineSpace() {
        System.out.println();
    }
}

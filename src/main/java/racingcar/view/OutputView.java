package racingcar.view;

public class OutputView {

    public void printWinners(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }

    public void printRaceResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printRaceResult(String carName, String Markers) {
        System.out.println(carName + " : " + Markers);
    }

    public void printBlankLine() {
        System.out.println();
    }

    public void printErrorMessage(Exception exception) {
        System.out.println("Error: " + exception.getMessage());
    }
}

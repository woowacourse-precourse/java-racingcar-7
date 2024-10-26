package racingcar.view;

public class OutputView {

    public void printRaceResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printRaceResult(String carName, String Markers) {
        System.out.println(carName + " : " + Markers);
    }

    public void printBlankLine() {
        System.out.println();
    }
}

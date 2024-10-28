package racingcar.view;

public class OutputView {

    public void showResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRacing(String carName, int distance) {
        System.out.println(carName + " : " + "-".repeat(distance));
    }

    public void printWinners(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}

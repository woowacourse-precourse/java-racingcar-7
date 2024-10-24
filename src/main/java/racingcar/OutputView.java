package racingcar;

public class OutputView {

    public void printStartRacing() {
        System.out.println("실행 결과");
    }

    public void printRacingStatus(Racing racing) {
        System.out.print(racing.toString());
    }

    public void printRacingWinners(Racing racing) {
        System.out.printf("최종 우승자 : %s", String.join(", ", racing.getWinnerCarNames()));
    }
}

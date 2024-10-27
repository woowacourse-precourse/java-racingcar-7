package racingcar.view;

public class OutputView {
    public void printGameStart() {
        System.out.println("\n실행 결과");
    }

    public void printCarStatus(string carName, int position) {
        System.out.println(name + " : " + "-".repeat(position)); //라운드별 자동차 상태 출력
    }

    public void printRoundEnd() {
        System.out.println(); //라운드 종료 후 한 줄 띄우기
    }
}

package racingcar.view;

import java.util.List;

public class OutputView {
    public void printGameStart() {
        System.out.println("\n실행 결과");
    }

    public void printCarStatus(String carName, int position) {
        System.out.println(carName + " : " + "-".repeat(position)); //라운드별 자동차 상태 출력
    }

    public void printRoundEnd() {
        System.out.println(); //라운드 종료 후 한 줄 띄우기
    }

    public void printWinners(List<String> winners) {
        String winnerNames = String.join(", ", winners.toArray(new String[0]));
        System.out.println("최종 우승자 : " + winnerNames);
    }
}

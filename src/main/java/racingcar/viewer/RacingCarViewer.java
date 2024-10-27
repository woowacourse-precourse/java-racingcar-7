package racingcar.viewer;

import java.util.List;
import java.util.Map;

public class RacingCarViewer {

    public void promptCarNamesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
    }

    public void promptTryNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void showWinners(List<String> winners) {
        String result = "";
        for (String winner : winners) {
            result = result.concat(winner);
            if (!winner.equals(winners.getLast())) {
                result += ", ";
            }
        }
        System.out.println("최종 우승자 : " + result);
    }

    public void showFinalRacingResult(Map<String, String> racingResult) {
        racingResult.forEach((k, v) -> System.out.println(k + " : " + v));
        System.out.println();
    }

    public void showRepeatRacingResult() {
        System.out.println("실행 결과");
    }
}

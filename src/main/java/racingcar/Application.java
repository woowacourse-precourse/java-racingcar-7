package racingcar;

import java.util.List;
import java.util.Scanner;

/**
 * 자동차 경주 게임을 진행하는 클래스
 * - ','를 기준으로 자동차 이름을 입력받음
 * 이름은 5자 이하만 가능
 * - 몇 회차까지 할 건지 입력받음
 * - 입력받은 횟수만큼 랜덤을 돌린다.
 * - 회차별로 실행결과를 출력한다.
 * ex) 실행 결과
 * pobi : -
 * woni : 
 * jun : -
 * 반복하여 입력받은 회차까지 실행한다.
 * - 최종 우승자를 출력한다.(이때 우승자는 한명 이상일 수 있다.)
 * 최종결과 작성 방식
 * ex) 최종 우승자 : pobi
 * ex) 최종 우승자 : pobi, jun
 */

public class Application {
    public static void main(String[] args) {
        // scanner
        List<String> carNames = Input.inputCarNames();
        int round = Input.inputRound();

        RacingGame racingGame = new RacingGame(carNames);

        // 레이싱 게임 생성 및 플레이
        for (int i = 0; i < round; i++) {
            racingGame.playNextRound();
            RoundStatus roundStatus = racingGame.getRoundStatus();
            Output.showRound(roundStatus);
        }

        WinnerStatus winnerStatus = new WinnerStatus(racingGame.getRoundStatus().getCarStatusList());
        Output.showWinner(winnerStatus);
    }
}

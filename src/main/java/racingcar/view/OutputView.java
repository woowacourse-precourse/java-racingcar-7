package racingcar.view;

import racingcar.domain.Player;

import java.util.List;

public class OutputView {

    public void printRacingResult(List<Player> players) {
        System.out.println("실행 결과");
        for (Player player : players) {
            System.out.println(player.getName() + " : " + "-".repeat(player.getScore()));
        }
    }

    public void printWinner(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }
}

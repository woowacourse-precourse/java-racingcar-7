package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String text = Console.readLine().trim();

        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine().trim();

        if (!CarRace.isNumeric(input) || Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 숫자여야 합니다.");
        }

        int numberOfRounds = Integer.parseInt(input);
        System.out.println("실행 결과");


        List<String> playerList = CarRace.getPlayerList(text);

        Map<String, Integer> playerStatus = new HashMap<>();
        for (String player : playerList) {
            playerStatus.put(player, 0);
        }

        for (int i = 0; i < numberOfRounds; i++) {
            CarRace.updatePlayerStatus(playerStatus);
            CarRace.printRaceStatus(playerStatus); // 라운드별 상태 출력
        }
        CarRace.findWinner(playerStatus);
    }
}

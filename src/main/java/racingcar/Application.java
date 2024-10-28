package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        // 경주에 참가하는 자동차이름 입력
        String input_players = Console.readLine();

        //쉼표(,)기준으로 이름을 구분한 후 players에 저장 후 각각의 전진 횟수를 기록하는 scores 생성
        ArrayList<String> players = new ArrayList<>(List.of(input_players.split(",")));
        ArrayList<String> scores = new ArrayList<>(Collections.nCopies(players.size(), ""));

        System.out.println("시도할 횟수는 몇 회인가요?");
        // 경주횟수 입력
        String input_game = Console.readLine();
        int n = Integer.parseInt(input_game);
    }
}

package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        // 경주에 참가하는 자동차이름 입력
        String input_players = Console.readLine();

        // 쉼표(,)기준으로 이름을 구분한 후 players에 저장 후 각각의 전진 횟수를 기록하는 scores 생성
        ArrayList<String> players = new ArrayList<>(List.of(input_players.split(",")));
        ArrayList<String> scores = new ArrayList<>(Collections.nCopies(players.size(), ""));

        System.out.println("시도할 횟수는 몇 회인가요?");
        // 경주 횟수 입력
        String input_game = Console.readLine();
        int n = Integer.parseInt(input_game);
        // 우승 스코어 초기화
        int win_score = 0;

        System.out.println("\n실행 결과");
        // 경주 횟수 만큼 경기진행
        while (n-- > 0) {
            for (int i = 0; i < players.size(); i++) {
                // 0 ~ 9 까지의 랜덤 값 중에 4 이상이 나오면 전진('-' 추가)
                int chk = Randoms.pickNumberInRange(0, 9);
                if (chk >= 4) {
                    String move = "-";
                    scores.set(i, scores.get(i) + move);
                }
                // 우승 스코어 최신화
                if (scores.get(i).length() > win_score) {
                    win_score = scores.get(i).length();
                }
                // 현재 자동차 스코어 출력
                System.out.println(players.get(i) + " : " + scores.get(i));
            }
            System.out.print("\n");
        }
        // 우승 스코어 (가장 앞 선 점수)의 우승자 선정
        String winner = "최종 우승자 : ";
        for (int i = 0; i < players.size(); i++) {
            if (scores.get(i).length() == win_score) {
                // 공동 우승자가 존재 할 수 있으니 쉼표(',') 추가
                winner += (players.get(i) + ", ");
            }
        }
        // 최송 우승자 혹은 공동 우승자 뒤에 붙은 쉼표(',') 제거
        winner = winner.substring(0, winner.length() - 2);
        // 최종 우승자 혹은 공동 우승자 출력
        System.out.println(winner);
    }
}
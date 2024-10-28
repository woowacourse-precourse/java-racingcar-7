package racingcar;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.parseInt;

public class Application {
    public static void main(String[] args) {
        String name="";
        int movements=0;
        List<String> names = new ArrayList<>();
        List<String> winner = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        name=Console.readLine();
        names = Arrays.asList(name.split("\\s*,\\s*"));
        Players players = new Players();
        players.addPlayers(names);

        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            movements = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("잘못된 숫자 입력입니다. 다시 입력해주세요.");
        }

        RandomMove rm = new RandomMove();
        rm.randomMove(movements);

        winner=players.whoIsWinner();
        System.out.println("최종 우승자 : " + winner);
    }
}

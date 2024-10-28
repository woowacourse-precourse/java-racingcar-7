package racingcar.view;

import racingcar.controller.PlayStation;
import racingcar.service.Game;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserView {

    public static PlayStation turnOnPlayStation(Game game) {
        return new PlayStation(game);
    }

    public static void printResult(List<String> result) {
        System.out.println("result = " + result);
        System.out.println("실행 결과");
        result.forEach(System.out::println);
    }

    public static List<String> printAndGetNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
        return List.of(readLine().split(","));
    }

    public static Integer printAndGetRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(readLine());
    }
}

package racingcar.view;

import racingcar.controller.PlayStation;
import racingcar.service.Game;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserView {

    public static PlayStation turnOnPlayStation(Game game) {
        return new PlayStation(game);
    }

    public static void printResult(List<String> result) {
        System.out.println("실행 결과");
        result.forEach(System.out::println);
    }

    public static List<String> printAndGetNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
        return getListAndCheck(readLine());
    }

    private static List<String> getListAndCheck(String s) {
        List<String> names = Arrays.asList(s.split(","));
        for (String name : names) {
            if (name.length() > 5 || name.isEmpty() || name.isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
            }
        }
        return names;
    }


    public static Integer printAndGetRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        return getParsedIntAndCheck();
    }

    private static int getParsedIntAndCheck() {
        int parsedInt = Integer.parseInt(readLine());
        if (parsedInt < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return parsedInt;
    }
}

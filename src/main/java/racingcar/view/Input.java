package racingcar.view;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분";
    private static final String INPUT_GAME_NUMBER = "시도할 횟수는 몇 회인가요?";

    public static List<String> inputCarName(){
        System.out.println(INPUT_CAR_NAME);
        List<String> carNames = Arrays.stream(readLine()
                        .split(","))
                .toList();
        return carNames;
    }

    public static int inputGameNumber(){
        System.out.println(INPUT_GAME_NUMBER);
        String numberOfGames = readLine();
        return Integer.parseInt(numberOfGames);
    }
}

package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInput = readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int round = Integer.parseInt(readLine());

        GameContext gameContext = GameContext.getGameContext(carNameInput, round);

        System.out.println("실행 결과");
        gameContext.run();
        List<String> gameResult = gameContext.findWinners();

        System.out.print("최종 우승자 : " + String.join(",", gameResult));
    }
}

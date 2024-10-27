package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int attemptsNum = Integer.parseInt(Console.readLine());

        Game game = new Game(CarName.carNameFilter(input));

        System.out.println("실행 결과");
        for (int i = 1; i <= attemptsNum; i++) {
            game.attemptStatus();
        }

        List<String> winners = game.findWinners();
        System.out.println("최종 우승자 : " + String.join(", ", winners));

        Console.close();
    }
}
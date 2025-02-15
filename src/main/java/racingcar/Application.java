package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    private static List<String> carNames = new ArrayList<>();
    private static Integer round;
    public static void main(String[] args) {
        readUserInput();
        RacingCarGame game = new RacingCarGame(carNames, round);

        game.start();

        List<String> winnerNames = game.selectWinners();

        System.out.println("최종 우승자 : " + String.join(", ", winnerNames));
    }

    private static void readUserInput(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        carNames.addAll(Arrays.asList(input.split(",")));

        for(String name: carNames){
            if(name.length() > 5) throw new IllegalArgumentException("자동차 이름의 길이가 5 초과 입니다.");
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        input = Console.readLine();
        round = Integer.parseInt(input);

        Console.close();
    }
}

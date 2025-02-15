package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.race.Race;
import racingcar.race.RaceCar;
import racingcar.race.RacePreparation;
import racingcar.race.RaceResult;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String matchCount = Console.readLine();

        System.out.println("실행 결과");
        Race race = new RaceCar(new RacePreparation(input, matchCount));
        RaceResult result = race.startRacingGame();

        List<String> winners = result.getWinner();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}

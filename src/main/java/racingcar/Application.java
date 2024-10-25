package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.race.*;
import racingcar.util.RandomGenerator;
import racingcar.util.RandomNumberGenerator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String matchCount = Console.readLine();

        RacePreparation racePreparation = new RacePreparation(input, matchCount);
        RandomGenerator randomGenerator = new RandomNumberGenerator();
        RacePrinter racePrinter = new RacePrinter();
        Movement movement = new Movement(randomGenerator);

        System.out.println("실행 결과");
        Race race = new RaceCar(racePreparation, racePrinter, movement);
        RaceResult result = race.startRacingGame();

        List<String> winners = result.getWinner();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}

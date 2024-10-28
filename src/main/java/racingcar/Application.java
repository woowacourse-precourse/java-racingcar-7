package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.getWinners.GetWinners;
import racingcar.race.Race;

public class Application {
    public static void main(String[] args) {
        String[] carNames = Console.readLine().split(",");

        int rounds = Integer.parseInt(Console.readLine());

        try {
            Race race = new Race(carNames);
            GetWinners getWinners = new GetWinners(race);
            race.start(rounds);

            System.out.println("최종 우승자 : " + String.join(", ", getWinners.getWinners()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}

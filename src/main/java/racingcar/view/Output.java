package racingcar.view;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import racingcar.model.Cars;
import racingcar.model.Race;

public class Output {
    public void printRoundStatus(Cars cars, int count) {
        Map<String, Integer> roundStatus = cars.getRoundStatus();

        if (count == 0) {
            System.out.println();
            System.out.println("실행 결과");
        }
        for (Entry<String, Integer> entry : roundStatus.entrySet()) {
            String name = entry.getKey();
            int position = entry.getValue();

            System.out.print(name + " : ");
            for (int i = 0; i < position; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printRaceWinners(Race race) {
        List<String> winners = race.getWinners();

        System.out.print("최종 우승자 : ");
        String raceWinners = String.join(", ", winners);
        System.out.println(raceWinners);
    }
}
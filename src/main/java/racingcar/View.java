package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import racingcar.input.*;
import racingcar.object.RealCar;

public class View {
    private View() {
    }

    public static void integrateView() {
        Integer max = 0;
        String playerinput = DataInput.getInput();
        System.out.println(playerinput);
        String[] players = DataParsing.parseData(playerinput);
        List<RealCar> cars = new ArrayList<>();

        for (String player : players) {
            cars.add(new RealCar(player));
        }

        Integer matchinput = MatchInput.getMatches();

        System.out.println(matchinput);

        while (max < matchinput) {
            max = progressOfRace(cars, max);
        }
        List<String> winners = judgeEqual(cars, matchinput);

        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }

    private static List<String> judgeEqual(List<RealCar> cars, Integer matchInput) {
        List<String> winners = new ArrayList<>();
        for (RealCar car : cars) {
            if (Objects.equals(car.getRaceTimes(), matchInput)) {
                winners.add(car.getCarName());
            }
            //이걸 어떻게 뺄 수 있지
        }
        return winners;
    }

    private static Integer progressOfRace(List<RealCar> cars, Integer max) {
        for (RealCar car : cars) {
            car.moveCar();
            car.getMoveHistory();
            max = makeMax(car, max);
        }
        return max;
    }

    private static Integer makeMax(RealCar car, Integer max){
        if (max < car.getRaceTimes()) {
            max = car.getRaceTimes();
        }

        return max;
    }
}

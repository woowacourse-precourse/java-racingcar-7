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
        List<String> winners = new ArrayList<>();
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
            for (RealCar car : cars) {
                car.moveCar();
                car.getMoveHistory();
                if (max < car.getRaceTimes()) {
                    max = car.getRaceTimes();
                }
            }
        }
        for(RealCar car : cars) {
            if(Objects.equals(car.getRaceTimes(), matchinput)) {
                winners.add(car.getCarName());
            }
        }

        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }
}

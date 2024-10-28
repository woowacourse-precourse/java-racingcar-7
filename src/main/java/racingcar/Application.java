package racingcar;
import java.util.*;
public class Application {
    public static void main(String[] args) {
        RaceUtil raceUtil = new RaceUtil();
        ArrayList<String> raceCarNames = raceUtil.inputRaceCar();
        int cnt = raceUtil.inputRaceCount();

        ArrayList<RaceCar> raceCars = new ArrayList<>();
        for(String name : raceCarNames) {
            raceCars.add(new RaceCar(name));
        }

        RaceCarGame raceCarGame = new RaceCarGame(raceCars, cnt);
    }
}

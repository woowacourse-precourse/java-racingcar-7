package racingcar;
import java.util.*;
public class Application {
    public static void main(String[] args) {
        RaceUtil raceUtil = new RaceUtil();
        ArrayList<String> raceCarNames = raceUtil.inputRaceCar();
        int cnt = raceUtil.inputRaceCount();

        for(String rcn : raceCarNames) System.out.print(rcn);
        System.out.println();
        System.out.println(cnt);
    }
}

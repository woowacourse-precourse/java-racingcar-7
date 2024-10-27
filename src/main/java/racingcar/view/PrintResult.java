package racingcar.view;

import java.util.List;

public class PrintResult {

    public void printRace(List<String> names, List<Integer> raceResult) {
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i) + " : " + "-".repeat(raceResult.get(i)));
        }
        System.out.println();
    }
}

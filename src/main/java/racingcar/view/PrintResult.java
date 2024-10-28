package racingcar.view;

import java.util.List;

public class PrintResult {

    public void printRace(List<String> names, List<Integer> raceResult) {
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i) + " : " + "-".repeat(raceResult.get(i)));
        }
        System.out.println();
    }

    public void printRaceResult(List<Integer> maxIndex, List<String> names) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < maxIndex.size(); i++) {
            System.out.print(names.get(maxIndex.get(i)));
            if (i < maxIndex.size() - 1) {
                System.out.print(",");
            }
        }
    }
}

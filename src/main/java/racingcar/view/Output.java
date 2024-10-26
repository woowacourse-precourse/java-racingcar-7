package racingcar.view;

import java.util.HashMap;
import java.util.List;

public class Output {

    public void printProgressByStage(HashMap<String, Integer> raceStatus) {
        for (String key : raceStatus.keySet()) {
            System.out.println(key + " : " + returnString(raceStatus.get(key)));
        }
        System.out.println();
    }

    public String returnString(int length) {
        StringBuilder hyphen = new StringBuilder();
        for (int i = 0; i < length; i++) {
            hyphen.append("-");
        }
        return hyphen.toString();
    }

    public void printWinners(List<String> winners) {

    }
}

package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class RacingCar {
    private Map<String, StringBuilder> status;
    private int round;

    RacingCar(List<String> cars, int round) {
        this.status = new HashMap<>();
        cars.forEach(name -> this.status.put(name, new StringBuilder()));

        this.round = round;
    }

    public List<String> getCars() {
        return status.keySet().stream().toList();
    }

    public List<StringBuilder> getStatus() {
        return status.values().stream().toList();
    }

    public void race() {
        System.out.println("\n실행결과");
        for(int i = 0; i < this.round; i++) {
            go();
            show();
        }

        pickAWinner();
    }

    public void pickAWinner() {
        int longest = getLongestDistance();

        StringBuilder resultOutput = new StringBuilder("최종 우승자 : ");
        for(Entry<String, StringBuilder> entry : status.entrySet()) {
            if (longest == entry.getValue().length()) {
                resultOutput.append(entry.getKey()).append(", ");
            }
        }

        System.out.println(resultOutput.substring(0, resultOutput.length()-2));
    }

    public void go() {
        for (String key: status.keySet()) {
            if (Randoms.pickNumberInRange(0, 9) >= 4)
                status.get(key).append("-");
        }
    }

    public void show() {
        StringBuilder statusOutput = new StringBuilder();
        for (String key: status.keySet()) {
            statusOutput.append(key).append(" : ").append(status.get(key)).append("\n");
        }

        System.out.println(statusOutput);
    }

    public int getLongestDistance() {
        return status.values().stream()
                .mapToInt(StringBuilder::length)
                .max()
                .orElse(0);
    }
}

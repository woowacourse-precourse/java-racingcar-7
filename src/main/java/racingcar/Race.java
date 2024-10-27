package racingcar;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Race {

    public void startRace(HashMap<String, Integer> car, int tryNumber) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < tryNumber; i++) {
            updateCarLocations(car);
            System.out.println();
        }
    }

    private void updateCarLocations(HashMap<String, Integer> car) {
        for (String i : car.keySet()) {
            int currentLocation = car.get(i);
            if (decideMovement()) {
                car.replace(i, currentLocation + 1);
            }
            System.out.println(i + " : " + "-".repeat(car.get(i)));
        }
    }

    private boolean decideMovement() {
        int randomNum = pickNumberInRange(0, 9);
        return randomNum > 3;
    }

    public void resultRace(HashMap<String, Integer> car) {
        System.out.print("최종 우승자 : ");

        Optional<Map.Entry<String, Integer>> winner = car.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        winner.ifPresent(entry -> {
            String winners = car.entrySet().stream()
                    .filter(e -> e.getValue().equals(entry.getValue()))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.joining(", "));
            System.out.println(winners);
        });
    }
}

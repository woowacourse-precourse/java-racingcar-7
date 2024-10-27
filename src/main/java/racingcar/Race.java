package racingcar;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Race {

    public void startRace(HashMap<String, Integer> car, int tryNumber) {
        System.out.println("\n실행 결과");
        while (tryNumber > 0) {
            updateCarLocations(car);
            System.out.println();
            tryNumber -= 1;
        }
        resultRace(car);
    }

    private void updateCarLocations(HashMap<String, Integer> car) {
        for (String i : car.keySet()) {
            int currentLocation = car.get(i);
            if (decideMovement()) {
                car.replace(i, currentLocation + 1);
            }
            String carLocation = "-";
            System.out.println(i + " : " + carLocation.repeat(car.get(i)));
        }
    }

    private boolean decideMovement() {
        int randomNum = pickNumberInRange(0, 9);
        return randomNum > 3;
    }

    private void resultRace(HashMap<String, Integer> car) {
        System.out.print("최종 우승자 : ");
        Optional<Integer> maxValue = car.values().stream().max(Integer::compareTo);
        maxValue.ifPresent(value -> {
            String maxKeys = car.entrySet().stream()
                    .filter(entry -> entry.getValue().equals(value))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.joining(", "));
            System.out.println(maxKeys);
        });
    }
}

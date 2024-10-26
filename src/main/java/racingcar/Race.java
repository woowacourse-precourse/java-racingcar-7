package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Race {
    public static void startRace(LinkedHashMap<String, StringBuffer> cars, int count) {
        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
            moveOrStop(cars);
            System.out.println();
        }
        checkFinalWinner(cars);
    }

    private static void moveOrStop(LinkedHashMap<String, StringBuffer> cars) {
        for (String name : cars.keySet()) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                cars.replace(name, cars.get(name).append("-"));
            }
            System.out.println(name + " : " + cars.get(name));
        }
    }

    private static void checkFinalWinner(LinkedHashMap<String, StringBuffer> cars) {
        int winnerDistance = cars.values().stream().mapToInt(StringBuffer::length).max().orElse(0);
        List<String> winners = cars.entrySet().stream().filter(entry -> entry.getValue().length() == winnerDistance)
                .map(Map.Entry::getKey)
                .toList();
        String result = String.join(",", winners);
        System.out.println("최종 우승자 : " + result);
    }
}

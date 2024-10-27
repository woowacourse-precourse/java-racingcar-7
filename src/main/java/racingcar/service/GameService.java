package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class GameService {
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;

    private final int gameCount;
    private final Map<String, Integer> carMap;
    private List<Map<String, Integer>> record;

    public GameService(int gameCount, List<String> carNames) {
        this.gameCount = gameCount;
        this.carMap = generateCarMap(carNames);

    }

    private Map<String, Integer> generateCarMap(List<String> carNames) {
        Map<String, Integer> carMap = new LinkedHashMap<>();
        for (String carName: carNames) {
            carMap.put(carName, 0);
        }
        return carMap;
    }

    public Map<String, Integer> getCars() {
        return new LinkedHashMap<>(carMap);
    }

    public List<Map<String, Integer>> getRecord() {
        return new ArrayList<>(record);
    }

    public List<String> getWinners() {
        int maxValue = 0;
        for (int value: carMap.values()) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        List<String> winners = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: carMap.entrySet()) {
            if (entry.getValue() == maxValue) {
                winners.add(entry.getKey());
            }
        }

        return winners;
    }

    public void move(String car, int num) {
        if (num >= 4) {
            carMap.merge(car, 1, Integer::sum); // 현재 키 값에 1을 더함.
        }
    }

    private int generateRandomInRange() {
        return Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
    }

    public void runGame() {
        carMap.replaceAll((key, value) -> 0); // 게임 시작시 모든 자동차 출발선(0)으로 초기화
        record = new ArrayList<>();

        int randomNumber;
        for (int cnt = 0; cnt < gameCount; cnt++) {
            for (String car: carMap.keySet()) {
                randomNumber = generateRandomInRange();
                move(car, randomNumber);
            }
            record.add(getCars()); // 게임 판마다 진행상황 저장
        }

    }

}

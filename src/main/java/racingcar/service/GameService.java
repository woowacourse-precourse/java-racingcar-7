package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class GameService {
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;

    private final int gameCount;
    private final Map<String, Integer> cars;
    private List<Map<String, Integer>> record;

    public GameService(int gameCount, Map<String, Integer> cars) {
        this.gameCount = gameCount;
        this.cars = cars;

    }

    public Map<String, Integer> getCars() {
        return new HashMap<>(cars);
    }

    public List<Map<String, Integer>> getRecord() {
        return new ArrayList<>(record);
    }

    public List<String> getWinners() {
        int maxValue = 0;
        for (int value: cars.values()) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        List<String> winners = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: cars.entrySet()) {
            if (entry.getValue() == maxValue) {
                winners.add(entry.getKey());
            }
        }

        return winners;
    }

    public void move(String car, int num) {
        if (num >= 4) {
            cars.merge(car, 1, Integer::sum); // 현재 키 값에 1을 더함.
        }
    }

    public int generateRandomInRange(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }

    public void runGame() {
        cars.replaceAll((key, value) -> 0); // 게임 시작시 모든 자동차 출발선(0)으로 초기화
        record = new ArrayList<>();

        int randomNumber;
        for (int cnt = 0; cnt < gameCount; cnt++) {
            for (String car: cars.keySet()) {
                randomNumber = generateRandomInRange(RANDOM_MIN, RANDOM_MAX);
                move(car, randomNumber);
            }
            record.add(getCars()); // 게임 판마다 진행상황 저장
        }

    }

}

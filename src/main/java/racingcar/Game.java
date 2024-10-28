package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    private List<Car> cars;
    private int raceCount;

    public Game(List<Car> cars, int raceCount) {
        this.cars = cars;
        this.raceCount = raceCount;
    }

    // 경주 시작
    public void startRace() {
        for (int i=0; i<raceCount; i++) {
            randomMove();
            // 각 차수 별 상태 출력
            RacingCarOutput output = new RacingCarOutput();
            output.getRaceState(cars);
        }
    }

    // 자동차별 난수 발생
    public void randomMove() {
        for (Car c : cars) {
            c.move(Randoms.pickNumberInRange(0, 9));
        }
    }

    public List<String> getFinalWinners() {
        int maxLength = cars.stream().mapToInt(Car::getLength).max().getAsInt();
        List<String> list = new ArrayList<>();
        Map<String, Integer> nameLengthMap = new HashMap<>();

        for (Car car : cars) {
            String name = car.getName();
            int length = car.getLength();
            // 현재 자동차 이름이 nameLengthMap에 존재하는지 확인(이름 중복 확인)
            if (nameLengthMap.containsKey(name)) {
                // nameLengthMap에 현재 자동차의 이름이 이미 존재한다면, 해당 이름의 이전 값과 현재 길이 비교하여
                // 더 큰 값 저장
                nameLengthMap.put(name, Math.max(nameLengthMap.get(name), length));
            } else {
                nameLengthMap.put(name, length);
            }
        }

        // nameLengthMap 안에 있는 키와 값 쌍 반복
        for (Map.Entry<String, Integer> entry : nameLengthMap.entrySet()) {
            String name = entry.getKey();
            int length = entry.getValue();
            if (length == maxLength) {
                list.add(name);
            }
        }

        return list;
    }
}

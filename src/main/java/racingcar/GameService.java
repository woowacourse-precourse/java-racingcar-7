package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

// 레이싱게임의 서비스 로직
// 차 목록, 시도 횟수
public class GameService {
    private final List<Car> cars;
    private final int tryNumber;

    public GameService(String inputNames, String inputCount) {
        this.cars = parseCarNames(inputNames);
        this.tryNumber = parseCount(inputCount);
    }

    private List<Car> parseCarNames(String inputNames) {
        if (inputNames == null || inputNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }

        String[] names = inputNames.split(",");
        List<Car> carList = new ArrayList<>();

        for (String name : names) {
            carList.add(new Car(name.trim()));
        }

        return carList;
    }

    private int parseCount(String inputCount) {
        try {
            int count = Integer.parseInt(inputCount);
            if (count <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getCount() {
        return tryNumber;
    }
}

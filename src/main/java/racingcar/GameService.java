package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

// 레이싱게임의 서비스 로직
// 차 목록
public class GameService {
    private final List<Car> cars;

    public GameService(String inputNames) {
        this.cars = parseCarNames(inputNames);
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

    public List<Car> getCars() {
        return cars;
    }
}

package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarNameParser {
    private final String inputCarNames;
    public List<String> carNames;

    public CarNameParser(String inputCarNames) {
        this.inputCarNames = inputCarNames.trim();
        carNames = parseCarName();
        validateCarName(carNames);
    }

    private List<String> parseCarName() {
        if (inputCarNames.isEmpty()) {
            System.out.println("자동차 이름이 입력되지 않았습니다. 올바른 자동차 이름을 입력해주세요.");
            throw new IllegalArgumentException();
        }
        String[] carNameArray = inputCarNames.split(",");
        List<String> carNameList = new ArrayList<>();
        for (String carName : carNameArray) {
            if (!carNameList.contains(carName.trim())) {
                carNameList.add(carName.trim());
            }
        }
        return carNameList;
    }

    private void validateCarName(List<String> carNames) {
        if (carNames.size() <= 1) {
            System.out.println("자동차가 두 대 이상일때 경주를 시작할 수 있어요");
            System.out.println("자동차를 두 대 이상 입력해주세요");
            throw new IllegalArgumentException();
        }
        for (String carName : carNames) {
            if (carName.length() > 5) {
                System.out.println("자동차 이름은 5글자 이하만 가능해요");
                throw new IllegalArgumentException();
            }
        }
    }

    public List<String> getCarNames() {
        return carNames;
    }
}

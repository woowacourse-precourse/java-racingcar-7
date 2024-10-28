package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarNameParser {
    private final String inputCarNames;
    public List<String> carNames;

    public CarNameParser(String inputCarNames) {
        this.inputCarNames = inputCarNames.trim();
        carNames = parseCarName();
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
}

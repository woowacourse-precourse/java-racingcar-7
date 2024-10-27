package racingcar;

import java.util.List;

public class Cars {
    private final List<String> nameList;
    private static final int INCLUDE_LAST_EMPTY_STRING = -1;

    public Cars(String namesStr) {
        List<String> nameList = List.of(namesStr.split(",", INCLUDE_LAST_EMPTY_STRING));

        validateWrongValue(nameList);
        validateNameLength(nameList);

        this.nameList = nameList;
    }

    public List<String> getNameList() {
        return nameList;
    }

    private void validateNameLength(List<String> cars) {
        for (String carName : cars) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름이 5자를 초과했습니다.");
            }
        }
    }

    private void validateWrongValue(List<String> cars) {
        if (cars.contains("")) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }
}

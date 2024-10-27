package racingcar.model;

import java.util.HashSet;

public class RacingCarName {

    private String[] list;

    public RacingCarName(final String[] carNames) {
        validateDuplicateNames(carNames);
        this.list = carNames;
    }

    public String[] getList() {
        return list;
    }

    public static void validateDuplicateNames(final String[] carNames) {
        var nameSet = new HashSet<String>();
        for (String name : carNames) {
            if (!nameSet.add(name)) {
                throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
            }
        }
    }
}

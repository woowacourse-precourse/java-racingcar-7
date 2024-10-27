package domain;

import java.util.List;

public class CarNames {

    private static final String DUPLICATE_ERROR_MESSAGE = "중복되지 않은 이름을 입력해야 합니다.";
    private static final Integer MINIMUM_CAR_NUMBER = 2;
    private static final String CAR_NUMBER_ERROR_MESSAGE = "자동차는 2개 이상을 입력해야 합니다.";

    private List<CarName> names;

    public CarNames(final List<CarName> names) {
        validateInputSize(names);
        validateDuplicate(names);
        this.names = names;
    }


    private static void validateDuplicate(final List<CarName> names) {
        Boolean result = names.stream()
                .distinct()
                .count() != names.size();

        if (!result) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    private static void validateInputSize(final List<CarName> names) {
        if (names.size() < MINIMUM_CAR_NUMBER) {
            throw new IllegalArgumentException(CAR_NUMBER_ERROR_MESSAGE);
        }
    }

    public List<CarName> getNames() {
        return names;
    }
}

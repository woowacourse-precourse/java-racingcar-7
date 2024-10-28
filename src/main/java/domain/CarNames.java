package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Set<String> check = new HashSet<>();
        for (CarName name: names) {
            check.add(name.getName());
        }

        if (check.size() != names.size()) {
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

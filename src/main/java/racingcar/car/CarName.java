package racingcar.car;

public class CarName {
    
    private static final String CAR_NAME_REGEX = "[a-Z가-힣]+";
    private final String name;

    protected CarName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (!name.matches(CAR_NAME_REGEX)) {
            throw new IllegalArgumentException(name + " 이름 형식 오류");
        }
    }

    protected String getName() {
        return name;
    }
}

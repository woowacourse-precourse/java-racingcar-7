package racingcar.model.car;

public class Car {
    private static final String KOREAN_ENGLISH_REGEX = "^[a-zA-Z가-힣]+$";
    private static final Integer MAX_CAR_NAME_LENGTH = 5;
    private final MoveStrategy moveStrategy;


    private final String carName;
    private int position = 0;

    public Car(String carName, MoveStrategy moveStrategy) {
        validateCarName(carName);
        this.carName = carName;
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        if (moveStrategy.canMove()) {
            position++;
        }
    }

    private void validateCarName(String carName) {
        validateGap(carName);
        validateLanguage(carName);
        validateNameLength(carName);
    }

    private void validateGap(String carName) {
        if(carName.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에 공백이 포함될 수 없습니다.");
        }
    }

    private void validateLanguage(String carName) {
        if(!carName.matches(KOREAN_ENGLISH_REGEX)) {
            throw new IllegalArgumentException("자동차 이름은 한글과 영어만 포함해야합니다.");
        }
    }

    private void validateNameLength(String carName) {
        if(carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }
}

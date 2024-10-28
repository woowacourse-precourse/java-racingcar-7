package racingcar.domain.model;

public class Car {
    private final static String BLANK_CAR_NAME_MESSAGE = "자동차 이름이 비어있습니다.";
    private final static String CAR_NAME_TOO_LONG_MESSAGE = "자동차 이름 %d자 초과 되었습니다.";
    private final static Integer MAX_CAR_NAME_LENGTH = 5;

    private final String name;
    private Integer moveCount;
    private final MoveConditionEvaluator moveConditionEvaluator;

    private Car(String name, Integer moveCount, MoveConditionEvaluator moveConditionEvaluator) {
        this.name = name;
        this.moveCount = moveCount;
        this.moveConditionEvaluator = moveConditionEvaluator;
    }

    static Car of(String name) {
        validateName(name);
        return new Car(name, 0, new RandomMoveConditionEvaluator());
    }

    static Car of(String name, MoveConditionEvaluator moveConditionEvaluator) {
        validateName(name);
        return new Car(name, 0, moveConditionEvaluator);
    }

    private static void validateName(String name) {
        validateBlankName(name);
        validateNameLength(name);
    }

    private static void validateBlankName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(BLANK_CAR_NAME_MESSAGE);
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    String.format(CAR_NAME_TOO_LONG_MESSAGE, MAX_CAR_NAME_LENGTH)
            );
        }
    }

    public String getName() {
        return name;
    }

    public Integer getMoveCount() {
        return moveCount;
    }

    public void move() {
        if(moveConditionEvaluator.isCanMove()) {
            this.moveCount++;
        }
    }
}

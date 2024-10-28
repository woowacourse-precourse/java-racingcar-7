package racingcar.validator;

public class Validator {
    private static final Integer CAR_NAME_LENGTH=5;

    public void nameValidate(String name) throws IllegalArgumentException {
        if (name.length() > CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하이여야 합니다.");
        }
    }

    public void trialValidate(String trial) {
        try {
            Integer.parseInt(trial);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자를 입력해야합니다.");
        }

        if (Integer.parseInt(trial) <0) {
            throw new IllegalArgumentException("시도할 횟수는 양의 정수이여야 합니다.");
        }
    }

}

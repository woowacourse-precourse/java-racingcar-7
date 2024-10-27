package racingcar.validator;

public class CarNameValidator {
    public static void carNameValidator(String name){
        if(name.isEmpty() || name.length()>5 || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 1글자 이상 5글자 이하여야합니다.");
        }
    }
}

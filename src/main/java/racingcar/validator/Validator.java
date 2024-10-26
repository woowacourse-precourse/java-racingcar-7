package racingcar.validator;

public class Validator {
    public static void validateCarName(String name){
        if(name.length()>5){
            throw new IllegalArgumentException("이름은 5자 이하입니다.");
        }
    }

    public static void validateTryNumber(String tryNumber){
        try{
            Integer.parseInt(tryNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
}

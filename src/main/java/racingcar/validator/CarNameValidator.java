package racingcar.validator;

public class CarNameValidator {
    private CarNameValidator(){
    }

    public static void validateCarNameLength(String input){
        if(input.length() > 5){
            throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
        }
    }

    public static void validateEnd(String input){
        if(input.endsWith(",")){
            throw new IllegalArgumentException("입력의 마지막은 콤마(,)로 끝날 수 없습니다.");
        }
    }

    public static void validateDelimiter(String input){
        
    }
}

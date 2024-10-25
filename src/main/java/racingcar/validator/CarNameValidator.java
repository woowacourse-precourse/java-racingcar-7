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
        String regex = "^[^,]*$";
        if(input.matches(regex)){
            throw new IllegalArgumentException("자동차 이름들은 콤마로 구분해야합니다.");
        }
    }

    public static void validateNotBlank(String input){
        if(input.isBlank()){
            throw new IllegalArgumentException("빈 칸은 입력할 수 없습니다.");
        }
    }

    public static void validateNoSpace(String input){
        if(input.contains(" ")){
            throw new IllegalArgumentException("이름에 공백이 포함될 수 없습니다.");
        }
    }

}

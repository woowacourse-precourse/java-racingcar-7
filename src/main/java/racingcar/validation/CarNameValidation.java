package racingcar.validation;

public class CarNameValidation {
    public static void validateNotNullOrEmpty(String input){
        if(input == null || input.trim().isEmpty()){
            throw new IllegalArgumentException();
        }
    }
    public static void validateNameLength(String input){

    }
    public static void validateNoWhitespace(String input){

    }
    public static void validateNoDuplicateNames(String input){

    }


}

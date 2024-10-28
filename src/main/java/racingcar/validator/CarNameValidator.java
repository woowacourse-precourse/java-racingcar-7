package racingcar.validator;

public class CarNameValidator {
    private static final String EMPTY_NAME_ERROR_MESSAGE = "빈 이름은 입력 할 수 없습니다.";
    private static final String START_OR_END_WITH_COMMA_ERROR_MESSAGE = "빈 이름은 입력 할 수 없습니다.";
    private static final String NAME_LENGTH_OVER_FIVE_ERROR_MESSAGE = "자동차 이름은 5자를 넘을 수 없습니다.";

    String input;

    public CarNameValidator(String input){
        this.input = input;
    }

    public boolean isValidate(){
        startOrEndWithComma();
        containsEmptyName();
        carNameLengthOverFive();

        return true;
    }

    private void startOrEndWithComma(){
        if(input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException(START_OR_END_WITH_COMMA_ERROR_MESSAGE);
        }
    }

    private void containsEmptyName(){
        if(input.replaceAll("\\s+", "").contains(",,")) {
            throw new IllegalArgumentException(EMPTY_NAME_ERROR_MESSAGE);
        }
    }

    private void carNameLengthOverFive(){
        for(String carName: input.split(",")){
            if(carName.trim().length() > 5){
                throw new IllegalArgumentException(NAME_LENGTH_OVER_FIVE_ERROR_MESSAGE);
            }
        }
    }
}

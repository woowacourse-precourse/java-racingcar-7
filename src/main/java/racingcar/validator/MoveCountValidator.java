package racingcar.validator;

public class MoveCountValidator {
    private static final String INPUT_NOT_NUMBER_ERROR_MESSAGE = "이동 횟수는 숫자만 입력 할 수 있습니다.";
    private static final String INPUT_MINUS_NUMBER_ERROR_MESSAGE = "이동 횟수에는 음수를 입력 할 수 없습니다.";
    private static final String INPUT_NUMBER_OVER_RANGE_ERROR_MESSAGE = "이동 횟수는" + Long.MAX_VALUE + "범위를 넘을 수 없습니다.";

    private String input;

    public MoveCountValidator(String input){
        this.input = input;
    }

    public boolean isValidate(){
        isNumber();
        isMinus();
        isInRange();

        return true;
    }

    private void isNumber(){
        if(!input.matches("-?[0-9]+")){
            throw new IllegalArgumentException(INPUT_NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    private void isMinus(){
        if(input.startsWith("-")){
            throw new IllegalArgumentException(INPUT_MINUS_NUMBER_ERROR_MESSAGE);
        }
    }

    private void isInRange(){
        try{
            Long.parseLong(input);
        }catch (Exception e){
            throw new IllegalArgumentException(INPUT_NUMBER_OVER_RANGE_ERROR_MESSAGE);
        }
    }
}

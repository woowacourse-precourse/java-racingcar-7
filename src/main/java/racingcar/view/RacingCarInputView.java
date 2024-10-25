package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.ValidatedInputDataDTO;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.policy.RacingPolicy;
import racingcar.exception.ExceptionMessage;

public class RacingCarInputView{

    private static final String INPUT_GUIDELINE_NAME = "경주할 자동차 이름을 입력해주세요 (이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_GUIDELINE_TRY_COUNT = "시도할 횟수를 입력해주세요";
    private static final int MAX_SIZE = 19;
    private static final int ZERO = 0;


    public ValidatedInputDataDTO receiveInputData(RacingPolicy racingPolicy){
        return new ValidatedInputDataDTO(receiveName(racingPolicy), receiveTryCount());
    }

    public String receiveName(RacingPolicy racingPolicy){
        System.out.println(INPUT_GUIDELINE_NAME);
        String input = validateReplaceInput(Console.readLine());
        validateNoSeparatorOrThrow(input,racingPolicy);
        //중복값 검사
        String[] splitInput = input.split(racingPolicy.getNameSeparator());
        duplicateNameAndThrow(splitInput);
        validateNameLengthOrThrow(splitInput,racingPolicy);
        return input;
    }

    public void validateNameLengthOrThrow(String[] splitInput,RacingPolicy racingPolicy) {
        List<Integer> collect = Arrays.stream(splitInput)
                .map(String::length)
                .filter(input -> input > racingPolicy.getNameLengthPolicy())
                .toList();

        if(!collect.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessage.MAX_LENGTH_EXCEEDED.getMessage());
        }
    }

    public void validateNoSeparatorOrThrow(String input,RacingPolicy racingPolicy) {
        if(!input.contains(racingPolicy.getNameSeparator())
                && input.length()>racingPolicy.getNameLengthPolicy()){
            throw new IllegalArgumentException(ExceptionMessage.DELIMITER_NOT_VALID.getMessage());
        }

    }

    public void duplicateNameAndThrow(String[] split) {
        List<String> splitList = Arrays.stream(split).distinct().toList();
        if(splitList.size() != split.length){
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NAME_NOT_ALLOWED.getMessage());
        }
    }

    public String validateReplaceInput(String input){
        String replace = input.replace(" ", "");
        validateBlankAndThrow(replace);
        return replace;
    }

    public void validateBlankAndThrow( String replace) {
        if (replace.isBlank()|| replace.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BLANK_INPUT.getMessage());
        }
    }

    /**
     * receiveTryCount() :
     * @return : Long 타입으로 변환된 시도횟수(tryCount)
     */

    public Long receiveTryCount(){
        System.out.println(INPUT_GUIDELINE_TRY_COUNT);
        String validateInput = validateReplaceInput(Console.readLine());
        return validateInputNumber(validateInput);
    }

    public Long validateInputNumber(String validateInput) {
        try {
            validateLongLengthAndThrow(validateInput);
            return validateNegativeAndThrow(Long.parseLong(validateInput));
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_COUNT_FORMAT.getMessage());
        }

    }

    public void validateLongLengthAndThrow(String validateInput) {
        if(validateInput.length()>MAX_SIZE){
            throw new IllegalArgumentException(ExceptionMessage.MAX_COUNT_LENGTH_EXCEEDED.getMessage());
        }
    }

    public Long validateNegativeAndThrow(Long number){
        if(number<ZERO){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NON_POSITIVE_COUNT.getMessage());
        }
        return number;
    }

}

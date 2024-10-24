package view;

import camp.nextstep.edu.missionutils.Console;
import dto.ValidatedInputDataDTO;
import java.util.Arrays;
import java.util.List;
import policy.RacingPolicy;

public class RacingCarInputView{

    private static final String INPUT_GUIDELINE_NAME = "경주할 자동차 이름을 입력해주세요 (이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_GUIDELINE_TRY_COUNT = "시도할 횟수를 입력해주세요";
    private static final String NAME = "이름";
    private static final String TRY_COUNT = "시도횟수";
    private static final String TRY_COUNT_LENGTH = "9,223,372,036,854,775,807";


    public ValidatedInputDataDTO receiveInputData(RacingPolicy racingPolicy){
        return new ValidatedInputDataDTO(receiveName(racingPolicy), receiveTryCount());
    }

    public String receiveName(RacingPolicy racingPolicy){
        System.out.println(INPUT_GUIDELINE_NAME);
        String input = validateReplaceInput(NAME, Console.readLine());
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
            throw new IllegalArgumentException("이름의 길이는 " + racingPolicy.getNameLengthPolicy() + "를 넘을 수 없습니다.");
        }
    }

    public void validateNoSeparatorOrThrow(String input,RacingPolicy racingPolicy) {
        if(!input.contains(racingPolicy.getNameSeparator())
                && input.length()>racingPolicy.getNameLengthPolicy()){
            throw new IllegalArgumentException("구분자를 바르게 입력해주세요.");
        }
    }

    public void duplicateNameAndThrow(String[] split) {
        List<String> splitList = Arrays.stream(split).distinct().toList();
        if(splitList.size() != split.length){
            throw new IllegalArgumentException("중복된 "+NAME+"은 입력할 수 없습니다.");
        }
    }

    public String validateReplaceInput(String type, String input){
        String replace = input.replace(" ", "");
        validateBlankAndThrow(type, replace);
        return replace;
    }

    public void validateBlankAndThrow(String type, String replace) {
        if (replace.isBlank()|| replace.isEmpty()){
            throw new IllegalArgumentException(type +"에는 공백만 입력할 수 없습니다.");
        }
    }

    /**
     * receiveTryCount() :
     * @return : Long 타입으로 변환된 시도횟수(tryCount)
     */

    public Long receiveTryCount(){
        System.out.println(INPUT_GUIDELINE_TRY_COUNT);
        String validateInput = validateReplaceInput(TRY_COUNT, Console.readLine());
        return validateInputNumber(validateInput);
    }

    public Long validateInputNumber(String validateInput) {
        try {
            validateLongLengthAndThrow(validateInput);
            return validateNegativeAndThrow(Long.parseLong(validateInput));
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(TRY_COUNT + "는 숫자로 입력해 주세요.");
        }

    }

    public void validateLongLengthAndThrow(String validateInput) {
        if(validateInput.length()>19){
            throw new IllegalArgumentException(TRY_COUNT + "는 "+ TRY_COUNT_LENGTH+"를 넘을 수 없습니다.");
        }
    }

    public Long validateNegativeAndThrow(Long number){
        if(number<0){
            throw new IllegalArgumentException(TRY_COUNT + "는 양수로 입력해주세요");
        }
        return number;
    }

}

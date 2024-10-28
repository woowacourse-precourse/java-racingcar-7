package racingcar.view;

import static racingcar.common.ErrorMessage.NOT_NULL_AND_NOT_BLANK;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final InputView INSTANCE = new InputView();
    private static final String PROMPT_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String PROMPT_TIME = "시도할 횟수는 몇 회인가요?";
    private InputView(){}

    public String readNames(){
        System.out.println(PROMPT_NAME);
        String input = Console.readLine();
        validateNullAndBlank(input);
        return input;
    }

    public Integer readTime(){
        System.out.println(PROMPT_TIME);
        String input = Console.readLine();
        validateNullAndBlank(input);
        Console.close();
        return Integer.valueOf(input);
    }

    private void validateNullAndBlank(String input){
        if(input == null || input.isBlank()){
            throw new IllegalArgumentException(NOT_NULL_AND_NOT_BLANK.getMessage());
        }
    }
}

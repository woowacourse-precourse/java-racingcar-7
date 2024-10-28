package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_RACE_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private final String ILLEGAL_INPUT_ERROR_MESSAGE = "[ERROR] 올바른 입력값이 아닙니다. ";
    private final String NEGATIVE_INPUT_ERROR_MESSAGE = "[ERROR] 시도할 횟수는 음수가 될 수 없습니다.";

    public String readCarName(){
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        try{
            String input = readLine();
            return input;
        } catch(IllegalArgumentException e){
            throw new IllegalArgumentException(ILLEGAL_INPUT_ERROR_MESSAGE + e);
        }
    }

    public Integer readRaceCount(){
        System.out.println(INPUT_RACE_COUNT_MESSAGE);
        String cnt = readLine();
        System.out.println();

        try {
            Integer cntInt = Integer.parseInt(cnt);
            return checkRaceCountNegative(cntInt);
        }
        catch(IllegalArgumentException e){
            throw new IllegalArgumentException(ILLEGAL_INPUT_ERROR_MESSAGE + e);
        }
    }

    private Integer checkRaceCountNegative(Integer count){
        if(count < 0) {
            throw new IllegalArgumentException(NEGATIVE_INPUT_ERROR_MESSAGE);
        }
        return count;
    }
}

package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ViewInput {

    public static final String INITIAL_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String USER_INPUT_NUMBER_MESSAGE = "시도할 횟수는 몇 회인가요?";
    public static final String CAR_ERROR_MESSAGE = "입력된 값이 비어있거나 길이가 6이상입니다.";
    public static final String NUMBER_ERROR_MESSAGE = "입력된 값이 비어있거나 같이 0보다 작습니다.";
    public static final int MAX_NAME_SIZE = 5;

    public List<String> receiveCarNames() {
        System.out.println(INITIAL_MESSAGE);
        String input = Console.readLine();
        carNameValidator(input);
        return Arrays.asList(input.trim().split(","));
    }

    public int receiveRaceAttempts(){
        System.out.println(USER_INPUT_NUMBER_MESSAGE);
        String number = Console.readLine();
        numberValidator(number);
        return Integer.parseInt(number);
    }

    private void carNameValidator(String input){
        String[] names = input.split(",");

        for(String name : names){
            if(name.trim().length() > MAX_NAME_SIZE || name.isBlank()){
                throw new IllegalArgumentException(CAR_ERROR_MESSAGE);
            }
        }
    }

    private void numberValidator(String input) {
        try {
            if (Objects.isNull(input) || input.isBlank() || Integer.parseInt(input) < 0) {
                throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE, e);
        }
    }

}
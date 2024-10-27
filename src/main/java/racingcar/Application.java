package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가?";
  
    private static List<String> inputCarNames() {
    	System.out.println(INPUT_CAR_NAMES_MESSAGE);
    	String input = Console.readLine();
    	
    	List<String> carNames = new ArrayList<>(Arrays.asList(input.split(",")));
    	Validator.validateCarNames(carNames);
    	return carNames;    	
    }
    
    private static int inputTryCount() {
    	System.out.println(INPUT_TRY_COUNT_MESSAGE);
    	String input = Console.readLine();
        
        Validator.validateNumericInput(input);
        int tryCount = Integer.parseInt(input);
        
        Validator.validatePositiveTryCount(tryCount);
        
        return tryCount;
    			
    }
    
    public static void main(String[] args) {
    	List<String> carNames = inputCarNames();
        int tryCount = inputTryCount();
    }
}

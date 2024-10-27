package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가?";
    private static final String VALID_NAME_PATTERN = "^(?!_)[a-zA-Z0-9가-힣_]+(?<!_)$";
    
    public static List<String> inputCarNames() {
    	System.out.println(INPUT_CAR_NAMES_MESSAGE);
    	String input = Console.readLine();
    	
    	List<String> carNames = new ArrayList<>();
    	for (String name : input.split(",")) {
    		name = name.trim();
    		validateCarname(name, carNames);
    		carNames.add(name);
    	}
    	
    	return carNames;
    }
    
    public static int inputTryCount() {
    	System.out.println(INPUT_TRY_COUNT_MESSAGE);
    	
    	String input = Console.readLine();
    	validateNumericInput(input);
    	
    	int tryCount = Integer.parseInt(input);
    	validatePositiveTryCount(tryCount);
    	
    	return tryCount;
    }
    
    private static void validatePositiveTryCount(int tryCount) {
    	if(tryCount <= 0) {
    		throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
    	}
    }
    
    private static void validateNumericInput(String input) {
    	try {
    		Integer.parseInt(input);
    	} catch (NumberFormatException e) {
    		throw new IllegalArgumentException("시도 횟수는 숫자로 입력해야 합니다.");
    	}
    }
    
    public static void validateCarname(String name, List<String> carNames) {
    	validateNoSpaces(name);
    	validateLength(name);
    	validateNoInvalidCharacters(name);
    	validateNoDuplicates(name, carNames);
    }
    
    private static void validateNoSpaces(String name) {
    	if (name.contains(" ")) {
    		throw new IllegalArgumentException("자동차 이름에 공백이 포함될 수 없습니다.");
    	}
    }
    
    private static void validateLength(String name) {
    	if (name.length() > 5) {
    		throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
    	}    	
    }
    
    private static void validateNoInvalidCharacters(String name) {
    	if (!name.matches(VALID_NAME_PATTERN)) {
    		throw new IllegalArgumentException("자동차 이름은 영문자, 숫자, 한글만 포함하고, 언더바(_)는 처음이나 끝에 위치할 수 없습니다.");
    	}    	
    }
    
    private static void validateNoDuplicates(String name, List<String> carNames) {
    	if (carNames.contains(name)) {
    		throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
    	}
    }    	
    
    public static void main(String[] args) {
    	List<String> carNames = inputCarNames();
    	int tryCount = inputTryCount();
    }
}

package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	
	private static final int MAX_NAME_LENGTH = 5;
	
    public static void main(String[] args) {
      
    	String[] carName = inputCarNames();
    }
    
    private static String[] inputCarNames() {
    	System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분): ");
    	String inputNames = Console.readLine();
    	return validateCarNames(inputNames);
    }
  
    private static String[] validateCarNames(String inputNames) {
    	String[] carNames = inputNames.split(",");
    	carNamesData(carNames);
    	return carNames;
    }
    
    private static void carNamesData(String[] carNames) {
    	for (String name : carNames) {
    		lengthCheck(name);
    	}
    }
    private static void lengthCheck(String name) {
    	if (name.length() > MAX_NAME_LENGTH) 
    		throw new IllegalArgumentException();
    	
    }
   
}
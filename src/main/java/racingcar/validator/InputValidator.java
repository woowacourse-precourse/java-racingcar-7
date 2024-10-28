package racingcar.validator;

public class InputValidator {
	public static void validateCarNames(String[] names) {
		for(String name : names) {
			validateCarName(name.trim());
		}
	}
	public static void validateCarName(String name) {
		if(name == null || name.isEmpty() || name.length() > 5) {
			throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
			
		}
	}
	
	public static void validateTrilaNum(String trialNum) {
		 try {
	            int count = Integer.parseInt(trialNum);
	            if (count <= 0) {
	                throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
	            }
	        } catch (NumberFormatException e) {
	            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
	        }
		
		
	}

}

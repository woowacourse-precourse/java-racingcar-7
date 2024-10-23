package racingcar;

public class Validation {

	public static void validateCarNames(String[] carNames) {
		for (String carName : carNames) {
			if (carName.isEmpty() || carName.length() > 5) {
				throw new IllegalArgumentException("올바르지 못한 자동차이름");
			}
		}
	}

	public static int validateTryCounts(String tryCounts) {
		int counts;
		try {
			counts = Integer.parseInt(tryCounts);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자가 아닌 시도 횟수 입력");
		}
		if (counts <= 0) {
			throw new IllegalArgumentException("1이상을 입력해주세요");
		}
		return counts;
	}
}

package racingcar.view;

import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
	public Supplier<String> inputSupplier;
	public static final String ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
	public static final String COMMA = ",";
	public static final String INPUT_CANNOT_BE_EMPTY = "이름은 비어있을 수 없습니다.";
	public static final String ENTER_TRY_COUNTS = "시도할 횟수는 몇 회인가요?";
	private static final Pattern IS_NATURAL_NUMBER = Pattern.compile("^(0|[1-9][0-9]*)$");
	public static final String INPUT_MUST_BE_POSITIVE_NUMBER = "입력값은 양의 정수여야 합니다.";

	public InputView(Supplier<String> inputSupplier) {
		this.inputSupplier = inputSupplier;
	}

	public String[] getCarNames() {
		System.out.println(ENTER_CAR_NAMES);
		String input = inputSupplier.get();
		if (input.isBlank()) {
			throw new IllegalArgumentException(INPUT_CANNOT_BE_EMPTY);
		}
		return input.split(COMMA);
	}

	public String getTryCounts() {
		System.out.println(ENTER_TRY_COUNTS);
		String input = inputSupplier.get();
		Matcher matcher = IS_NATURAL_NUMBER.matcher(input);
		if (!matcher.matches()) {
			throw new IllegalArgumentException(INPUT_MUST_BE_POSITIVE_NUMBER);
		}
		return input;
	}
}

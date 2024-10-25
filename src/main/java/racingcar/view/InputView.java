package racingcar.view;

import java.util.function.Supplier;

public class InputView {
	public Supplier<String> inputSupplier;
	public static final String ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
	public static final String COMMA = ",";
	public static final String INPUT_CANNOT_BE_EMPTY = "이름은 비어있을 수 없습니다.";

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
}

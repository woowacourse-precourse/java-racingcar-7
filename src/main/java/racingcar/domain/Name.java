package racingcar.domain;

import racingcar.config.RaceConfig;

public class Name {
	private final String name;

	public Name(String name) {
		validateName(name);
		this.name = name;
	}

	private void validateName(String name) {
		validateNotBlank(name);
		validateLength(name);
		validateAlphabet(name);
	}

	private void validateNotBlank(String name) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("[ERROR] 자동차 이름은 비어있을 수 없습니다.");
		}
	}

	private void validateLength(String name) {
		if (name.length() > RaceConfig.MAX_NAME_LENGTH.getNumber()) {
			throw new IllegalArgumentException("[ERROR] 자동차 이름이 최대 길이를 초과했습니다.");
		}
	}

	private void validateAlphabet(String name) {
		if (!name.matches("^[a-zA-Z]+")) {
			throw new IllegalArgumentException("[ERROR] 입력값은 알파벳으로만 구성되어야 합니다.");
		}
	}

	public String getName() {
		return name;
	}
}

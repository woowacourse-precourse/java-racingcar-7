package racingcar.config;

public enum RaceConfig {
	INITIAL_DISTANCE(0),
	MOVE_CONDITION_NUMBER(4),
	MOVE_DISTANCE(1),
	RANDOM_NUMBER_START(0),
	RANDOM_NUMBER_END(9),
	MAX_NAME_LENGTH(5),
	MIN_PARTICIPANT_COUNT(2);

	private final int number;

	RaceConfig(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}

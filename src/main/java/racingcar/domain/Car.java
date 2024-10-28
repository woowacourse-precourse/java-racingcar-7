package racingcar.domain;

public class Car {
	private static final Integer MOVE_CONDITION_LIMIT = 4;

	private final String name;
	private Integer position;

	public Car(String name) {
		this.name = name;
		this.position = 0;
	}

	public void moveByCondition(Integer condition) {
		if (isMoveCondition(condition)) {position++;}
	}

	public String getName() {
		return name;
	}

	public Integer getPosition() {
		return position;
	}

	private Boolean isMoveCondition(int condition) {
		return condition >= MOVE_CONDITION_LIMIT;
	}
}

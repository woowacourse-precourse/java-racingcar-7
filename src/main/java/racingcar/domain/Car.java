package racingcar.domain;

public class Car {
	String name;
	int steps;

	private Car(String name) {
		this.name = name;
	}

	public static Car fromCarName(String name){
		name = name.strip();
		validateIsEmpty(name);
		validateExceedsMax(name);
		return new Car(name);
	}

	private static void validateExceedsMax(String name) {
		if(name.length() > 5){
			throw new IllegalArgumentException("차량 이름은 5자를 초과할 수 없습니다.");
		}
	}

	private static void validateIsEmpty(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException("차량 이름은 비어있을 수 없습니다.");
		}
	}

}

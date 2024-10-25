package racingcar.model;

public class ProgressResultGenerator {

	private static final String CAR_MOVEMENT_SYMBOL = "-";
	private static final String SEPARATOR = " : ";
	private static final String LINE_SEPARATOR = "\n";

	private static String generateCarStatus(Car car) {
		return car.getName() + SEPARATOR + formatMovementStatus(car.getMovement());
	}

	private static String formatMovementStatus(int number) {
		return CAR_MOVEMENT_SYMBOL.repeat(number);
	}
}

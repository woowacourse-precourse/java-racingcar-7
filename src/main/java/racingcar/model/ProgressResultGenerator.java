package racingcar.model;

public class ProgressResultGenerator {

	private static final String CAR_MOVEMENT_SYMBOL = "-";
	private static final String SEPARATOR = " : ";

	private static String formatMovementStatus(int number) {
		return CAR_MOVEMENT_SYMBOL.repeat(number);
	}
}

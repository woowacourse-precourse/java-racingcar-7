package racingcar.model.output;

import java.util.List;

public class WinnerResultGenerator {

	private static final int SINGLE_WINNER_COUNT = 1;
	private static final String SEPARATOR = ", ";

	public static String generateWinnerResult(List<String> winners) {
		if (checkJointWinners(winners)) {
			return generateJointWinnersResult(winners);
		}
		return winners.getFirst();
	}

	private static boolean checkJointWinners(List<String> winners) {
		return winners.size() > SINGLE_WINNER_COUNT;
	}

	private static String generateJointWinnersResult(List<String> winners) {
		return String.join(SEPARATOR, winners);
	}
}

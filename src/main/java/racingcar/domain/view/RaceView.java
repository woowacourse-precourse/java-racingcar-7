package racingcar.domain.view;

import static racingcar.common.util.Validator.*;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.util.ErrorMessage;
import racingcar.common.util.GameConstants;
import racingcar.common.util.GameMessage;
import racingcar.common.util.UTF8ConsoleWriter;
import racingcar.domain.model.RaceStatus;

public class RaceView {

	private static final String POSITION_FORMAT = "%s : %s";
	private static final String POSITION_MARKER = "-";

	public List<String> receiveCarNames() {
		UTF8ConsoleWriter.println(GameMessage.INPUT_CAR_NAMES.getMessage());
		String input = Console.readLine();
		return Arrays.asList(input.split(GameConstants.DEFAULT_SEPARATOR));
	}

	public int receiveRaceLap() {
		UTF8ConsoleWriter.println(GameMessage.INPUT_RACE_LAP.getMessage());
		try {
			int lap = Integer.parseInt(Console.readLine());
			validLapCount(lap);
			return lap;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.NUMBER_FORMAT_ERROR.getMessage());
		}
	}

	public void displayRaceProgress(List<RaceStatus> raceStatuses) {
		raceStatuses.forEach(status -> {
			String position = POSITION_MARKER.repeat(status.getPosition());
			UTF8ConsoleWriter.println(String.format(POSITION_FORMAT, status.getName(), position));
		});
		UTF8ConsoleWriter.print("\n");
	}

	public void displayWinners(String winner) {
		UTF8ConsoleWriter.println(GameMessage.RACE_RESULT.formatMessage(winner));
	}

	public void startRace() {
		UTF8ConsoleWriter.println(GameMessage.RACE_START.getMessage());
	}
}

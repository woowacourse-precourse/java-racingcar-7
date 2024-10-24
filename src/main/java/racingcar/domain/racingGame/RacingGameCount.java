package racingcar.domain.racingGame;

import java.util.regex.Pattern;

import racingcar.exception.racingGame.RacingGameException;
import racingcar.exception.racingGame.RacingGameExceptionMessage;

public class RacingGameCount {
	private final String NUMBER_REGEX = "^\\d+$";
	private final int count;

	public RacingGameCount(final String count) {
		validate(count);
		this.count = Integer.parseInt(count);
	}

	public int getCount() {
		return count;
	}

	private void validate(String count) {
		if(count.isBlank()){
			throw new RacingGameException(RacingGameExceptionMessage.NOT_BLANK);
		}
		if(!Pattern.matches(NUMBER_REGEX, count)){
			throw new RacingGameException(RacingGameExceptionMessage.NOT_NUMBER);
		}
		if(Integer.parseInt(count) <= 0){
			throw new RacingGameException(RacingGameExceptionMessage.OUT_OF_BOUND);
		}
	}
}

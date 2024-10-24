package racingcar.exception.racingGame;

import racingcar.exception.GlobalException;

public class RacingGameException extends GlobalException {
	public RacingGameException(RacingGameExceptionMessage message){
		super(message.getMessage());
	}
}

package racingcar.controller;

import static racingcar.constant.Letter.*;

import camp.nextstep.edu.missionutils.Console;
import racingcar.racing.Racing;
import racingcar.validator.Validator;

public final class ControllerImpl implements Controller {
	private final Validator validator;
	
	protected ControllerImpl(final Validator validator) {
		this.validator = validator;
	}
	
	@Override
	public final void run() {
		System.out.println(REQ_RACING_CAR_NAMES);
		final String inputRacingCarNames = Console.readLine();
		final String[] racingCarNameArr = validator.stringToArray(inputRacingCarNames);
		
		System.out.println(REQ_TRYING_COUNT);
		final String inputTryingCount = Console.readLine();
		final long tryingCount = validator.stringToLong(inputTryingCount);
		
		final Racing racing = Racing.getInstance(racingCarNameArr);
		racing.printResult(tryingCount);
		racing.printWinner();
	}
}

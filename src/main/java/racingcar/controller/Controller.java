package racingcar.controller;

import racingcar.validator.Validator;

public interface Controller {
	static Controller getInstance() {
		return new ControllerImpl(Validator.getInstance());
	}
	
	void run();
}

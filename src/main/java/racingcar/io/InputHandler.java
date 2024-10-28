package racingcar.io;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

	public List<String> getUserCarName() {
		return Arrays.asList(Console.readLine().trim().split(","));
	}

	public int getUserTryNumber() {
		return Integer.parseInt(Console.readLine());
	}
}

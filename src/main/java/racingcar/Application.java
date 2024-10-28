package racingcar;

import java.util.ArrayList;

class Player {
	String name;
	int racingProcessCount;

	Player(String name) {
		this.name = name;
		this.racingProcessCount = 0;
	}

}

class Function {
	public static void checkNameLengthOverFive(String name) {
		if (name.length() > 5) {
			throw new IllegalArgumentException();
		}
	}

	public static void checkNameDuplication(ArrayList<String> checkNameDuplicationList, String inputName) {
		if (checkNameDuplicationList.contains(inputName)) {
			throw new IllegalArgumentException();
		}

	}

}

public class Application {
	public static void main(String[] args) {

	}
}

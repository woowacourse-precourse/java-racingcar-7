package racingcar;

import java.util.ArrayList;

class Player {
	String name;
	int racingProcessCount;

	Player(String name) {
		this.name = name;
		this.racingProcessCount = 0;
	}

	public void canMoveForward() {
		if (camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9) >= 4) {
			this.racingProcessCount++;
		}
	}

	public String exchangeRacingProcessCountToString() {
		String racingString = "";
		for (int i = 0; i < this.racingProcessCount; i++) {
			racingString = racingString + "-";
		}

		return racingString;
	}

	public void printPlayerPresentState() {
		System.out.println(this.name + " : " + this.exchangeRacingProcessCountToString());
	}
}


	
public class Application {
	public static void main(String[] args) {
		
	}
}

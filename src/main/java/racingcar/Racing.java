package racingcar;

import java.util.LinkedHashMap;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class Racing {

	private Map<String, Integer> carMap = new LinkedHashMap<>();
	private int playCnt = 0;

	public void playRacing(Map<String, Integer> carMap, int playCnt) {
		this.carMap = carMap;
		this.playCnt = playCnt;
		start();
	}

	private void start() {
		System.out.println("실행결과");
		for (int i = 0; i < playCnt; i++) {
			playCnt();
		}
	}

	private void playCnt() {
		for (String carName : carMap.keySet()) {
			int random = random();
			carValue(carName, random);
		}
	}

	private int random() {
		return Randoms.pickNumberInRange(0, 9);
	}

	private void carValue(String carName, int random) {
		int value = carMap.get(carName);
		if (randomCheck(random)) {
			carMap.replace(carName, value + 1);
		}
	}

	private boolean randomCheck(int random) {
		return random >= 4;
	}

}
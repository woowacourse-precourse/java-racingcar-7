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
		}
	}

}
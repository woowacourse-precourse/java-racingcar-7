package racingcar;

import java.util.HashMap;
import java.util.Map;

public class CarArrayCheck {
	
	String[] carArray = {};
	int carLength = 0;
	Map<String, Integer> carMap = new HashMap<String, Integer>();
	
	public void carNameSplit(String carName) {
		this.carArray = carName.split(",");
		this.carLength = carArray.length;
		check();
	}
	
	private void check() {
		carArrayLength();
		carNameCheck();
		carMap();
	}
	
	private void carArrayLength() {
		if(carArray == null || carLength <= 1) {
			System.err.println("경주할 자동차를 2개 이상 입력해주세요.");
			throw new IllegalArgumentException(); 
		}
	}
	
	private void carNameCheck() {
		for(String name : carArray) {
			if(name.length() > 5) {
				System.err.println("자동차 이름은 5자 이하로 입력해주세요.");
				throw new IllegalArgumentException(); 
			}
			if(name.isEmpty()) {
				System.err.println("자동차 이름은 공백으로 입력할 수 없습니다.");
				throw new IllegalArgumentException(); 
			}
		}
	}
	
	private void carMap() {
		for(String name : carArray) {
			if(carMap.containsKey(name)) {
				System.err.println("자동차 이름은 중복될 수 없습니다.");
				throw new IllegalArgumentException(); 
			}
			carMap.put(name, 0);
		}
	}
}

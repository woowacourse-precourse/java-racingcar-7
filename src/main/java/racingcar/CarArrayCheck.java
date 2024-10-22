package racingcar;

public class CarArrayCheck {
	
	String[] carArray = {};
	int carLength = 0;
	
	public void carNameSplit(String carName) {
		this.carArray = carName.split(",");
		this.carLength = carArray.length;
		carArrayLength();
	}
	
	public void carArrayLength() {
		if(carArray == null || carLength <= 1) {
			System.err.println("경주할 자동차를 2개 이상 입력해주세요.");
			throw new IllegalArgumentException(); 
		}
	}
}

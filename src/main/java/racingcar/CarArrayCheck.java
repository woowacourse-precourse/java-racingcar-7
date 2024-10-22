package racingcar;

public class CarArrayCheck {
	
	String[] carArray = {};
	
	public void carNameSplit(String carName) {
		this.carArray = carName.split(",");
	}
}

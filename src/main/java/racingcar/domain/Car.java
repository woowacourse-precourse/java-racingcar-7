package racingcar.domain;

public class Car {
	private final String name;
	private int position;
	
	//생성자 
	public Car(String name) {
		this.name = name;
		this.position = 0;
	}
	
	//메소드 
	public void move(boolean shouldMove) {
		if(shouldMove) {
			position++;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public int getPosition() {
		return position;
	}
	
	public String getCurrentPosition() {
		return name+ " : " + "-".repeat(position);
	}
	

}

package racingcar;

public class Car {
    private final String name;
    private int position = 0;
    Car(String name){
        this.name = name;
    }

    // 자동자 전진함수
    public void moveForward(){
        // 전진함수 구현
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}

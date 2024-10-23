package racingcar;

public class RacingCar {
    private String name; // 자동차의 이름
    private int pos; // 자동차의 현재 위치
    private final int MOVESTANDARD = 4;

    public RacingCar(String name) {
        this.name = name;
        this.pos = 0;
    }

    public boolean isForward(int num) {
        return num >= MOVESTANDARD;
    }

    public void moveForward(int randomNum) {
        if(isForward(randomNum)) pos++;
    }

    public int getPos() {
        return pos;
    }
}

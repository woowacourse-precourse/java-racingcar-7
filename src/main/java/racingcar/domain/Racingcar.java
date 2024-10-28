package racingcar.domain;

public class Racingcar {

    private String name;
    private int position;

    public Racingcar(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void moveForward(int value) {
        // TODO: 메서드 구현
    }
}

package racingcar.car.model;

// 자동차의 상태를 나타내는 객체
public class CarStatus {
    private int position;

    public CarStatus(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void incrementPosition() {
        position++;
    }
}


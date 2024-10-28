package racingcar.vo;

public class TestCarVO {
    private static final int MOVE_TRIGGER_INT = 4;
    private final String carName;
    private int position;

    public TestCarVO(String carName) {
        this.carName = carName;
        this.position = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    // 외부에서 무작위 값을 주입하여 이동 여부를 결정할 수 있는 메서드
    public void move(int randomValue) {
        if (randomValue >= MOVE_TRIGGER_INT) {
            ++position;
        }
    }

    public String getCurrentState() {
        StringBuilder state = new StringBuilder(carName + " : ");
        for (int i = 0; i < position; i++) {
            state.append("-");
        }
        return state.toString();
    }
}

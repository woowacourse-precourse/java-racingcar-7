package racingcar.model;

import racingcar.constants.RacingGameConstants;

public class RacingCar {
    private final String name;
    private int position;

    public RacingCar(String name) {
        this.name = name;
        this.position = RacingGameConstants.INITIAL_POSITION.getValue();
    }

    // 무작위 값이 4 이상일 때 전진
    public void move(int randomValue) {
        if (canMove(randomValue)) {
            position++;
        }
    }

    // 전진 가능 여부 확인
    private boolean canMove(int randomValue) {
        return randomValue >= RacingGameConstants.MOVE_THRESHOLD.getValue();
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    // 현재 상태를 시각적으로 표시하는 메서드
    public String displayPosition() {
        String positionDisplay = "-".repeat(position);
        return String.format("%s : %s", name, positionDisplay);
    }

}

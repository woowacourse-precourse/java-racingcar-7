package racingcar.domain;

class MoveCondition {

    private final int moveConditionPoint;

    MoveCondition(int moveConditionPoint) {
        this.moveConditionPoint = moveConditionPoint;
    }

    int getConditionPoint() {
        return this.moveConditionPoint;
    }
}

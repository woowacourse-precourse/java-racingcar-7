package racingcar.service.move;

import racingcar.constant.move.MoveConstant;

public enum MoveState {
    MOVE(true),
    STOP(false);
    MoveState(boolean moveAble) {
        this.moveAble = moveAble;
    }
    private final boolean moveAble;
    public static boolean move(int moveCnt) {
        if (moveCnt >= MoveConstant.MOVE_THRESHOLD) return MOVE.moveAble;
        return STOP.moveAble;
    }
}

package racingcar;

public class CustomMoveStrategy implements MoveStrategy {

    // 자동차 움직임에 새로운 규칙이 추가되더라도 기존의 코드 변경 없이 확장 가능
    @Override
    public boolean shouldMove() {
        return true;
    }

}
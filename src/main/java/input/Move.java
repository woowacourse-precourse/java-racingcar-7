package input;

import camp.nextstep.edu.missionutils.Console;

public class Move {
    public int howManyMove() {
        // 원시값 포장 필요
        String isNumberOfMoveString = Console.readLine();
        int numberOfMove = isNumberOfMove(isNumberOfMoveString);

        return numberOfMove;
    }

    private int isNumberOfMove(String isNumberOfMoveString) {
        int numberOfMove = -1;

        try {
            numberOfMove = Integer.parseInt(isNumberOfMoveString);
        } catch (Exception e) {
            throw new IllegalArgumentException("입력하신 문자열은 시도 횟수 형식이 아닙니다. 숫자로 입력해주세요.");
        }
        if (numberOfMove <= 0) {
            throw new IllegalArgumentException("입력하신 숫자로는 자동차를 움직일 수 없습니다. 1 이상의 숫자를 입력해주세요.");
        }

        return numberOfMove;
    }
}

package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Racing {

    public static int randomNumber(int move) {

        // 0에서 9사이의 랜덤 값 구하기
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        System.out.println("Random number: " + randomNumber);

        return randomNumber;
    }
}

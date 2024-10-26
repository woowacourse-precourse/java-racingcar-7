package racingcar;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Racing {

    public static int randomNumber(int move) {

        // 0에서 9사이의 랜덤 값 구하기
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        System.out.println("Random number: " + randomNumber);

        return randomNumber;
    }

    private List<String> carNames;

    public Racing(List<String> carNames) {
        this.carNames = carNames;
    }
    public void printCarNames() {
        System.out.println("실행 결과");
        for (String name : carNames) {
            System.out.println(name.trim() + ":");
        }
    }
}

package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // 사용자로부터 자동차 이름을 입력받음
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameStr = Console.readLine();

        // 사용자로부터 시도할 횟수를 입력받음
        System.out.println("시도할 횟수는 몇 회인가요?");
        int n = Integer.parseInt(Console.readLine());

        /*라이브러리 확인*/
        /* pickNumberInRange 기능 확인 */
        int randomNum = Randoms.pickNumberInRange(0, 9);

        /* pickNumberInList 기능 확인 */
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5);
        int selectedNum = Randoms.pickNumberInList(numList);

        /*pickUniqueNumbersInRange 기능 확인 (0에서 9 사이의 고유한 숫자 중 3개 선택)*/
        List<Integer> selectedNumList = Randoms.pickUniqueNumbersInRange(0, 9, 3);

        /*shuffle 기능 확인 (리스트를 랜덤하게 셔플)*/
        List<Integer> shuffledNumList = Randoms.shuffle(numList);

        /*출력 확인*/
        System.out.println("I/O,라이브러리 체크 종료");

    }

}

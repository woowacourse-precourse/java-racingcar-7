package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutView;

public class Play {
    public void playRacing(String[] cars, int trialNum) {
        int carNum = cars.length;
        int[] carArr = new int[carNum]; // 자동차 갯수만큼 배열 생성하기 -> 얼마나 전진했는지 값 넣을거
        // 자바는 int 배열은 초기화 값이 0

        OutView result = new OutView();

        for (int i = 0; i < trialNum; i++) {
            for (int j = 0; j < carNum; j++) {
                int randomNum = Randoms.pickNumberInRange(0, 9);

                if (randomNum > 3) {
                    carArr[j] += 1;
                }
            }
            if (i == 0) {
                System.out.println("실헹 결과");
            }
            result.displayResult(carArr, cars);
            System.out.print("\n");
        }

        Result.printWinner(carArr, cars);

    }

}

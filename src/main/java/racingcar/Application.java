package racingcar;
import racingcar.view.*;
import racingcar.controller.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


public class Application {
    public static void main(String[] args)  {
        // TODO: 프로그램 구현

        // 차 이름 입력받기
        List<String> carNames = InputView.getCarNames();
        System.out.println(carNames);

        // 이름이 5자 이하인지 확인
        InputController.checkNameLimit(carNames);

        // 시도 횟수 입력받기
        int tryNum = InputView.getTryNum();
        System.out.println(tryNum);

        //


/*
        // 이름이 5자 이하인지 확인
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }*/
/*


        Map<List, Integer> carProgress = initializeCarProgress(carNames);

        System.out.println("\n실행 결과");

        for (int i = 0; i < attemptCount; i++) {
            raceCar(carNames, carProgress);
            printProgress(carNames, carProgress);
            System.out.println();
        }

        // 우승자 출력
        int maxProgress = 0;
        for (String carName : carNames) {
            maxProgress = Math.max(maxProgress, carProgress.get(carName));
        }

        StringBuilder winners = new StringBuilder();
        for (String carName : carNames) {
            if (carProgress.get(carName) != maxProgress) {
                continue;
            }
            if (winners.length() > 0) {
                winners.append(",");
            }
            winners.append(carName);
        }
        System.out.println("최종 우승자 : " + winners);

    }
    private static void raceCar (String[] carNames, Map<String, Integer> carProgress){
        for (String carName: carNames){
            if (Randoms.pickNumberInRange(0,9)>=4){
                carProgress.put(carName, carProgress.get(carName)+1);
            }
        }
    }
    // 자동차의 초기 전진 상태를 0으로 설정하는 메서드
    private static Map<String, Integer> initializeCarProgress(String[] carNames){
        Map<String, Integer> carProgress = new HashMap<>();
        for (String carName : carNames){
            carProgress.put(carName, 0);
        }
        return carProgress;
    }

    private static void printProgress(String[] carNames, Map<String, Integer> carProgress){
        for (String carName : carNames){
            System.out.print(carName + " : ");
            for (int i = 0; i < carProgress.get(carName); i++) {
                System.out.print("-");
            }
            System.out.println();
        }*/
    }

}




package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Play {
    // 게임 1회 진행 메소드
    public static void play(Car[] cars) {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            
            System.out.print(car.getName() + " : ");
            if (randomValue >= 4) {
                car.move();
            } else {
                car.stop();
            }
            System.out.println();   // 각 자동차 사이 한줄 출력
        }
        System.out.println();       // 게임 1회 진행 종료 시 한줄 출력
    }
}
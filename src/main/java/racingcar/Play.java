package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Play {
    // 게임 1회 진행 메소드
    public static void play(Car[] cars) {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9); // 0~9 사이 랜덤값 출력
            
            System.out.print(car.getName() + " : ");    // 자동차 이름 출력
            if (randomValue >= 4) {
                car.move();     // 랜덤값 4이상인 경우 전진 메소드
            } else {
                car.stop();     // 랜덤값 3이하인 경우 정지 메소드
            }
            System.out.println();   // 각 자동차 사이 한줄 출력
        }
        System.out.println();       // 게임 1회 진행 종료 시 한줄 출력
    }
}
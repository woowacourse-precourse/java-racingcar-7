package racingcar;

import racingcar.RacingCar;

/**
 * Application 클래스, 메인 진입점
 */
public class Application {

    /**
     * 프로그램의 시작점인 메인 메소드
     *
     * @param args
     */
    public static void main(String[] args) {
        // RacingCar 클래스의 객체 생성
        RacingCar racingCar = new RacingCar();

        // RacingCar 클래스의 멤버 run() 메소드 호출
        racingCar.run();
    }
}

package racingcar;

import racingcar.RacingCar;

/**
 * User 클래스, 각 참가자의 자동차 이름과 전진 횟수를 저장
 */
public class User {
    String name;
    int totalGo;

    User(String name) {
        this.name = name;
        totalGo = 0;
    }

    /**
     * 참가자의 자동차 이름과 전진 횟수 만큼 '-'로 표시된 문자열 반환
     *
     * @return 자동차 이름과 전진 횟수를 '-'로 나타낸 문자열
     */
    @Override
    public String toString() {
        String information = name + " : ";

        // 전진 횟수 만큼 문자열에 '-'를 더함
        for (int i = 0; i < totalGo; i++) {
            information += "-";
        }
        return information;
    }
}

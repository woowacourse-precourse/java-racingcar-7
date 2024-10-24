package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public String name;
    public int score;

    // Car 객체 생성
    public Car(String name) {
        this.name = name;
        this.score = 0;
    }

    // 점수 반환
    public int getScore() {
        return score;
    }

    // 차 이름 반환
    public String getName() {
        return name;
    }

    // 랜덤값이 4 이상일 경우 한 칸 전진
    public void move() {
        int randNum = Randoms.pickNumberInRange(0, 9);
        if (randNum >= 4) {
            score++;
        }
    }
}

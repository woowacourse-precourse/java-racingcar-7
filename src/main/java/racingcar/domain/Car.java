package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String carName;
    private int moveCount;

    public Car(String carName) {
        this.carName = carName;
        moveCount = 0;
    }

    /**
     * 무작위 숫자가 4이상이라면 전진
     */
    public void forwardCar(int randomNumber) {
        if (randomNumber >= 4) {
            moveCount += 1;
        }
    }

    /**
     * 0-9 사이의 무작위 숫자 생성
     */
    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    /**
     * 경주 게임 1번 실행
     */
    public void startOneGame() {
        int randomNumber = generateRandomNumber();
        forwardCar(randomNumber);
    }

    /**
     * 자동차 이름 getter
     */
    public String getCarName() {
        return carName;
    }

    /**
     * 전진 횟수 getter
     */
    public int getMoveCount() {
        return moveCount;
    }
}

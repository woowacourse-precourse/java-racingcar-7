package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class MoveHandler {

    // 0~9 범위의 랜덤 숫자를 생성
    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    // 자동차가 이동할 수 있는지 여부를 확인
    public boolean canMove(int randomNumber) {
        return randomNumber >= 4;
    }

    // 자동차 이동 처리
    public void moveCar(Car car) {
        if (canMove(generateRandomNumber())) {
            car.pos++;
        }
    }

    public void playRound(List<Car> cars){

        for(Car car : cars){
            moveCar(car);
        }
    }

}

package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Race {
    private final List<Car> CarList;
    private final int Attempt;

    // CarList 배열과 시도 횟수 매게 변수 선언
    public Race(List<Car> CarList, int Attempt) {
        this.CarList = CarList;
        this.Attempt = Attempt;
    }

    // 시도 횟수 만큼 레이스 진행
    public void PlayRace() {
        for (int i = 0; i < Attempt; i++) {
            PlayRound();
            //레이스 마다 구분을 위해 띄어쓰기
            System.out.println();
        }
    }

    // 0 ~ 9의 랜덤한 숫자 중 4 이상일 때 1칸 전진
    public void PlayRound() {
        for (Car car : CarList) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if (car.MoveCondition(randomNum)) {
                car.CarMove();
            }
            PrintCarPosition(car);
        }
    }

    // 자동차 이름 마다 "-"로 위치만큼 출력
    public void PrintCarPosition(Car car) {
        System.out.println(car.GetCarName() + " : " + "-".repeat(car.GetCarPosition()));
    }
}

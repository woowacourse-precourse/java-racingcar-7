package racingcar.service;

import racingcar.entity.CarList;
import racingcar.entity.Input;
import racingcar.entity.TryCount;
import racingcar.entity.Winners;

public interface CarService {

    // 입력을 받아 CarList 객체로 반환
    CarList toCarList(Input input);

    // 시도 횟수 객체를 입력받고 실행
    Winners process(CarList carList, TryCount tryCount);

    // 최종 결과 출력
    void result(Winners winners);

}

package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Car> carList = new ArrayList<>();

    public void initialize(){
        // 자동자 이름 읿력받는 함수 호출
        // 시도 횟수 입력받는 함수 호출
        int attempt = 0;
    }

    public void start(int attempt){
        while(attempt>0){
            for (Car car : carList){
                // 자동차 전진 함수 호출
            }
            attempt--;
        }
    }
}

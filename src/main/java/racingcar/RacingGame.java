package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    // cars 객체 생성
    private final List<Racingcar> cars;

    public RacingGame(List<String> carNames){
        cars = carNames.stream().map(Racingcar::new).collect(Collectors.toList());
    }

    public List<Racingcar> getCars(){
        return cars;
    }
    // 라운드 게임 goCar, getRandomnum
    public void raceOneRound(){
        for(Racingcar car : cars){
            if(Randoms.pickNumberInRange(0, 9) >= 4){
                car.move(); // 메서드 분리 리펙토링 필요
            }
        }
    }


}

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
    // 라운드 게임
    public void raceOneRound(){
        for(Racingcar car : cars){
            if(Randoms.pickNumberInRange(0, 9) >= 4){
                car.move(); // 메서드 분리 리펙토링 필요
            }
        }
    }
    // 우승자 찾기
    public List<Racingcar> finalWinner() {
        int maxPosition = cars.stream().mapToInt(Racingcar::getPosition).max().orElse(0);
        return cars.stream().filter(car -> car.getPosition() == maxPosition).collect(Collectors.toList());
    }
}

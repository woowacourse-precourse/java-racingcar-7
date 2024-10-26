package racingcar;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

/**
 * 자동차 경주 게임을 진행하는 클래스입니다.
 */
public class RacingGame {
    private static final int TRY_THRESHOLD = 4;
    
    private List<Car> cars;
    private int gameCount;
    private int tryCount;
    
    public RacingGame(List<String> cars, int gameCount) {
        this.cars = new ArrayList<Car>(cars.size());
        for (String name : cars) {
            this.cars.add(new Car(name));
        }
        this.gameCount = gameCount;
        this.tryCount = 0;
    }
    
    /**
     * 현재 게임이 종료되었는지 여부를 반환합니다.
     * @return 현재 게임이 종료되었다면 true를, 그렇지 않다면 false를 반환합니다.
     */
    public boolean isDone() {
        return (tryCount >= gameCount);
    }
    
    /**
     * 게임의 한 단계를 실행합니다.
     * @exception RuntimeException 게임이 끝났는데 호출할 경우 발생합니다.
     */
    public void startOneStep() {
        if (isDone()) {
            throw new RuntimeException("이미 게임이 끝났으나 다음 단계를 시도하려 했습니다!");
        }
        
        for (int i = 0; i < cars.size(); i++) {
            if (pickNumberInRange(0, 9) >= TRY_THRESHOLD) {
                cars.get(i).distance++;
            }
        }
        tryCount++;
    }
    
    /**
     * 현재 상태의 각 자동차 정보를 반환합니다.
     * 처음 입력된 자동차 이름 순서대로 반환합니다.
     * @return 현재 각 자동차별 정보가 담긴 리스트
     */
    public List<Car> getCarInfo() {
        return cars;
    }
    
    /**
     * 현재 상태의 가장 선두 자동차(들)을 반환합니다.
     * 처음 입력된 자동차 이름 순서대로 반환합니다.
     * @return 선두 자동차 정보가 담긴 리스트
     */
    public List<Car> getFrontRunners() {
        if (cars.size() == 0) {
            return new ArrayList<Car>(0);
        }
        
        int maxDistance = 0;
        for (Car c : cars) {
            if (maxDistance < c.distance) {
                maxDistance = c.distance;
            }
        }

        List<Car> result = new ArrayList<Car>(cars.size());
        for (Car c : cars) {
            if (c.distance == maxDistance) {
                result.add(c);
            }
        }
        
        return result;
    }
}

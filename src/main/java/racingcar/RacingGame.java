package racingcar;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

/**
 * 자동차 경주 게임을 진행하는 클래스입니다.
 */
public class RacingGame {
    private static final int TRY_THRESHOLD = 4;
    
    private List<String> cars;
    private int[] positions;
    private int gameCount;
    private int tryCount;
    
    public RacingGame(List<String> cars, int gameCount) {
        this.cars = cars;
        this.positions = new int[cars.size()];
        this.gameCount = gameCount;
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
        
        for (int i = 0; i < positions.length; i++) {
            if (pickNumberInRange(0, 9) >= TRY_THRESHOLD) {
                positions[i]++;
            }
        }
        tryCount++;
    }
    
    /**
     * 현재 상태의 각 자동차별 위치를 반환합니다.
     * @return 각 자동차별 위치가 기록된 정수 리스트
     */
    public int[] getPositions() {
        return positions.clone();
    }
}

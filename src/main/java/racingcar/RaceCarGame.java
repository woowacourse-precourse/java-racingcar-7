package racingcar;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.*;
public class RaceCarGame {
    private final ArrayList<RaceCar> cars;
    private final int cnt;
    /***
     * 레이스게임 생성자
     *
     * @param cars
     * @param cnt
     */
    RaceCarGame(ArrayList<RaceCar> cars, int cnt){
        this.cars = cars;
        this.cnt = cnt;
    }

    /***
     * 레이스 게임을 진행
     *
     */
    public void race(){
        System.out.println("실행 결과");
        for(int i = 0; i < this.cnt; i++){
            forwardUpdate();

        }
    }

    /***
     * 시도마다 진행되는 전진 랜덤 업데이트
     *
     */
    private void forwardUpdate(){
        for(RaceCar raceCar : this.cars){
            raceCar.updateForward(Randoms.pickNumberInRange(0, 9));
            showGameStatus();
        }
    }

    /**
     * 시도마다 각 레이스 상태를 출력하는 메소드
     *
     */
    private void showGameStatus(){
        for(RaceCar raceCar : this.cars){
            System.out.println(makeStatus(raceCar));
        }
        System.out.println();
    }

    /**
     * 현재 자동차의 상태를 만들어 반환하는 메소드
     *
     * @param raceCar
     * @return 현재 자동차의 상태를 문자열로 반환
     */
    private String makeStatus(RaceCar raceCar){
        return raceCar.getName() + " : " +
                "-".repeat(Math.max(0, raceCar.getForward()));
    }
}

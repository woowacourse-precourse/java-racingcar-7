package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Game {

    // 게임에 참여할 차들
    private List<Car> cars = new ArrayList<>();
    private int trialCount;

    // 시도 횟수 입력
    private void inputTrialCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            trialCount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력하세요.");
        }
    }

    public Game(List<Car> cars){
        this.cars = cars;
        inputTrialCount();
    }
}

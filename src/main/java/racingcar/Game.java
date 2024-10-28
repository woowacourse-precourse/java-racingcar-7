package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Car> cars = new ArrayList<>();
    private int trialCount;

    // 게임 시작
    public void StartGame(){
        inputTrialCount();

        for (int i = 0; i < trialCount; i++) {
            GoAheadOneRound(); // 한 라운드 진행
            printRoundResult(); // 라운드 결과 출력
        }
    }

    // 시도 횟수 입력
    private void inputTrialCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            trialCount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력하세요.");
        }
    }

    // 한 라운드 진행
    public void GoAheadOneRound(){
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            car.move(randomValue);
        }
    }

    // 라운드 결과 출력
    private void printRoundResult() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public Game(List<Car> cars){
        this.cars = cars;
    }


}

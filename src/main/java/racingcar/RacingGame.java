package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RacingGame {
    Car car = new Car();
    Integer attemptNum;

    public void run(){
        car.set();
        setAttemptNum();
        startGame();
    }

    private void setAttemptNum(){
        String attemptNumInput = UserView.readAttemptNum();
        checkAttemptNumContext(attemptNumInput);
        attemptNum = Integer.parseInt(attemptNumInput);
        checkAttemptNumSize();
    }

    private void checkAttemptNumContext(String attemptNumInput){
        if (!attemptNumInput.matches("^[0-9]+$")){
            throwArgumentException("시도 횟수는 양의 정수만 입력 가능합니다.");
        }
    }

    private void checkAttemptNumSize(){
        if (1 > attemptNum || attemptNum > 10){
            throwArgumentException("시도 횟수는 1 이상, 10 이하로 입력해야 합니다.");
        }
    }

    private void startGame(){
        UserView.changeLine();
        UserView.printResultGuide();
        List<String> cars = car.carMap.keySet().stream().toList();
        for (int i=0; i < attemptNum; i++){
            carMove(cars);
            printAttemptResult(cars);
        }
    }

    private void carMove(List<String> cars){
        for (String car: cars){
            if (Randoms.pickNumberInRange(0, 9) >= 4){
                this.car.carMap.replace(car, this.car.carMap.get(car) + 1);
            }
        }
    }

    private void printAttemptResult(List<String> cars){
        for (String car: cars){
            UserView.printPlayerAttemptResult(car, this.car.carMap.get(car));
        }
        UserView.changeLine();
    }

    private void throwArgumentException(String errorContext){
        throw new IllegalArgumentException(errorContext);
    }
}
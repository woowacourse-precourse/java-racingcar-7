package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.validator.TrialCountValidator;

public class RacingGameView {

    public void carNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void trialCountInputMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public String getCarNames(){
        return Console.readLine();
    }

    public int getTrialCount(){
        int trialCount = Integer.parseInt(Console.readLine());
        TrialCountValidator.trialCountValidator(trialCount);
        return trialCount;
    }

    public void showTrialResultsMessage(){
        System.out.println("\n실행 결과");
    }

    public void showRoundResult(List<Car> cars){
        for(Car car : cars){
            System.out.printf("%s : ", car.getName());
            System.out.println("-".repeat(car.getAdvance()));
        }
        System.out.println();
    }

    public void showFinalWinner(List<Car> cars){
        List<String> winners = new ArrayList<>();
        int maxAdvance = 0;
        for(Car car: cars){
            if(car.getAdvance()>maxAdvance){
                maxAdvance = car.getAdvance();
            }
        }
        for(Car car: cars){
            if(car.getAdvance()==maxAdvance){
                winners.add(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}

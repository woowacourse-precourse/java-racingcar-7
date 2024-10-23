package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.List;

public class CarRace {

    private final static Integer tryNumRange = 100;
    public void carRace(List<Car> carList){
        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryNumString = Console.readLine();
        validateTryNumConvert(tryNumString);


        //Randoms.pickNumberInRange(0, 9);

    }

    private void validateTryNumConvert(String tryNumString) {
        int tryNum = Integer.parseInt(tryNumString);
    }


}

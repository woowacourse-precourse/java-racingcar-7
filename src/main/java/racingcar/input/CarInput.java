package racingcar.input;

import camp.nextstep.edu.missionutils.Console;
// import racingcar.domain.CarNameSplitter;
import racingcar.Exception.ExceptionError;
import racingcar.caculator.WinnerCaculator;
import racingcar.domain.RandomValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//자동차의 이름과 경기 횟수를 입력받음
public class CarInput {
    RandomValue randomValue = new RandomValue();
    ExceptionError exceptionError = new ExceptionError();
    public void inputCarDetail() {
        //경주할 선수이름 입력
        //System.out.println("경주할 자동차 이름을 입력하세요.");
        String players = Console.readLine();

        if(players.isEmpty() || players.equals("") || players.length() >= 5) {
            throw new IllegalArgumentException();
        }

        //선수 ',' 구분
        List<String> carName = Arrays.asList(players.split(","));

        //경기횟수 입력
        //System.out.println("시도할 횟수는 몇 회인가요?");
        String racingNumberInput = Console.readLine();

        if (racingNumberInput.isEmpty() || racingNumberInput.isBlank()) {
            throw new IllegalArgumentException();
        }

        //해당 경기의 정보를 전송
        int racingNumber = Integer.parseInt(racingNumberInput);
        for(int repeat = 0; repeat < racingNumber; repeat++) {
            int valueLength = carName.size();
            randomValue.CarRandomValue(valueLength, racingNumber, repeat ,carName);
            System.out.println();
        }
    }
}

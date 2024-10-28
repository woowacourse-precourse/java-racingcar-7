package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.caculator.WinnerCaculator;
import racingcar.input.CarInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//0~9까지 랜덤한 숫자 정하기
public class RandomValue {
    WinnerCaculator winnerCaculator = new WinnerCaculator();
    public void CarRandomValue(int valueLength, int racingNumber,int repeat,List<String> carName) {
        List<Integer> carRandomNumber = new ArrayList<>();

        // 첫 선수부터 랜덤한 숫자부여
        for(int i = 0; i < valueLength; i++) {
            int randomNumber = Randoms.pickNumberInRange(0,9);
            carRandomNumber.add(randomNumber);
        }

        //각 경기별 우승자
        winnerCaculator.WinnerResult(carName, carRandomNumber, racingNumber, repeat);
    }
}

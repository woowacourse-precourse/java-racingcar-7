package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.input.CarInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//0~9까지 랜덤한 숫자 정하기

public class RandomValue {
    public void CarRandomValue(int valueLength, List<String> carName) {
        List<Integer> carRandomNumber = new ArrayList<>();

        // 첫 선수부터 랜덤한 숫자부여
        for(int i = 0; i < valueLength; i++) {
            int randomNumber = Randoms.pickNumberInRange(0,9);
            carRandomNumber.add(randomNumber);
        }

        // 경기 현황 출력
        for(int i = 0; i< carRandomNumber.size(); i++){
            int number = carRandomNumber.get(i);
            System.out.print(carName.get(i) + " : ");
            for(int j = 0; j < number; j++){
                System.out.print("-");
            }
            System.out.println();
        }

        //우승자 출력
    }
}

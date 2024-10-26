package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.model.RacingCar;

public class RacingGameService {
    private static final Integer NAME_LENGTH_LIMIT = 5;




    private String[] parseCarName(String carNames){
        return carNames.split(",");
    }

    private boolean validateTryCount(Integer tryCount){
        if (tryCount == 0){
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return true;
    }
    private boolean validateCarNames(String carNames){
        if (carNames == null || carNames.isEmpty()){
            throw new IllegalArgumentException("자동차 이름이 입력되지 않았습니다.");
        }

        String[] splitCarNames = parseCarName(carNames);

        for (String carName : splitCarNames){
            if (carName.length() > NAME_LENGTH_LIMIT){
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력 하셔야 합니다.");
            }
        }

        Set<String> carNameSet = new HashSet<>(Arrays.asList(splitCarNames));

        // 배열의 길이와 Set의 크기를 비교하여 중복된 이름이 있는지 확인
        if (splitCarNames.length != carNameSet.size()) {
            throw new IllegalArgumentException("자동차 이름에 중복된 이름이 있습니다.");
        }

        return true;
    }



}

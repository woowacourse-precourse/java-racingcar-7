package racingcar;

import java.util.HashSet;
import java.util.Set;

public class CheckInput {
    public String[] splitNames(String carNameString){
        String[] cars = carNameString.split(",");
        Set<String> nameSet = new HashSet<>();
        for(String car :cars){
            String trimmedCarName = car.trim();
            if(trimmedCarName.length()>5){
                throw new IllegalArgumentException("자동차의 이름은 다섯 글자를 넘을 수 없습니다.");
            }
            if(nameSet.contains(trimmedCarName)){
                throw new IllegalArgumentException("중복된 이름이 존재합니다.");
            }
            nameSet.add(trimmedCarName);
        }

        return nameSet.toArray(new String[0]);
    }

    public int isValidCount(String raceCountString) {
        if(raceCountString == null || raceCountString.isEmpty() || !raceCountString.matches("\\d+")){
            throw new IllegalArgumentException("올바른 숫자를 입력해 주세요.");
        }
        return Integer.parseInt(raceCountString);
    }
}

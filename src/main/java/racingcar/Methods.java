package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Methods {

    // 자동차의 현재 위치를 담는 map 생성
    private Map<String, StringBuilder> carConditions = new HashMap<>();

    // 자동차 이름 조건 체크 후 조건에 부합하면 다음 메서드로 반납
    public List<String> nameCheck(String inputCarNames){

        List<String> nameList = new ArrayList<>();

        String[] carNameArr = inputCarNames.split(",");
        for(String carName :carNameArr){
            if(carName.length()<5){
                nameList.add(carName);
                carConditions.put(carName,new StringBuilder());
            } else {
                throw new IllegalArgumentException(" 자동차 이름은 5자 이하로 작성해야합니다.");
            }
        }

     return nameList;
    }

    // 전진 메소드
    private void isMoving(String carName){

        int randomNum = pickNumberInRange(0,9);
        if(randomNum>=4){
            carConditions.get(carName).append("-");
        }

    }


}

package race;

import InputOutput.Input;

import java.util.HashMap;
import java.util.Map;

public class Race {
    public static Map<String, String> insertEnteredCarNamesIntoMap(){
        Map<String, String> race = new HashMap<String, String>();
        for (String key : Input.insertCarsName()) {
            key = key.trim();
            if(key.length() > 5){
                throw new IllegalArgumentException(key+": 이름은 5자 이하만 가능합니다.");
            }
            if(key == null || key.isEmpty()){
                throw new IllegalArgumentException("공백입니다.");
            }
            race.put(key, "");  // 키는 입력받은 값, 초기 값은 0으로 설정
        }
        return race;
    }
}
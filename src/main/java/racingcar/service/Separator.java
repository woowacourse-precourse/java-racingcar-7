package racingcar.service;

import java.util.Arrays;
import java.util.List;

public class Separator {
    private final String separate = ",";

    public Separator() {
    }

    public List<String> separateString(String input){
        try{
            String[] carsName = input.split(separate);
            if(carsName.length == 0 || input.isBlank()) {
                throw new IllegalArgumentException("자동차 이름이 입력되지 않았습니다.");
            }
            for(int i=0;i<carsName.length;i++){
                carsName[i]=carsName[i].trim();
            }

            return Arrays.stream(carsName).toList();
        } catch(IllegalArgumentException err){
            throw err;
        }
    }
}

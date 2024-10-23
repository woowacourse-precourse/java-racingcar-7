package racingcar.service;

import java.util.ArrayList;
import java.util.List;

public class ExtractName {
    public String[] extractName(String input){
        String[] names = input.split(",");
        String[] result = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            result[i] = names[i].trim(); // 각 이름의 앞뒤 공백 제거 후 결과 배열에 저장
        }
        return result;
    }
}

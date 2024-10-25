package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RacingCarService {

    public List<String> splitCarNames(String carNames){
        //공백이 넘어온 경우? 구분자가 없는 경우?
        List<String> listCarNames = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(carNames);

        while (stringTokenizer.hasMoreTokens()){
            listCarNames.add(stringTokenizer.nextToken(","));
        }

        return listCarNames;
    }
}

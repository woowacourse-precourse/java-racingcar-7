package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utility.CarRacing;
import utility.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarRacingTest{
    private static int idx = 0;
    private static final List<Integer> currentSituation = new ArrayList<>(Arrays.asList(0,0,1,3));
    private static List<Integer>[] answer = new List[]{
        new ArrayList<>(Arrays.asList(0,0,1,3)),
        new ArrayList<>(Arrays.asList(0,0,1,3)),
        new ArrayList<>(Arrays.asList(1,1,2,4)),
        new ArrayList<>(Arrays.asList(2,2,3,5)),
    };

    @ParameterizedTest
    @ValueSource(ints = {0,3,4,9})
    void carRacingTest(int randomNum){
        if(runMain(randomNum, currentSituation).equals(answer[idx++])){
            System.out.println("Success");
        }else{
            System.out.println("Fail");
        }
    }

    public List<Integer> runMain(int randomNum, List<Integer> currentSituation) {
        return CarRacing.test(randomNum, currentSituation);
    }
}

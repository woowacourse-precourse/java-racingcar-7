package racingcar.IO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinnerOutput {
    int[] result;
    String[] carNames;
    public WinnerOutput(int[] result, String[] carNames){
        this.result = result;
        this.carNames = carNames;
    }

    public void getWinner(){
        List<String> winners = new ArrayList<>();
        int max = Arrays.stream(result).max().getAsInt();
        for(int i=0; i< carNames.length; i++){
            if (result[i] == max){
                winners.add(carNames[i]);
            }
        }
        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : "+result);

    }
}

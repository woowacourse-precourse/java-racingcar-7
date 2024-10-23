package utility;

import racingcar.Application;

import java.util.List;

public class Result {
    // 진행 결과 출력
    public static void printOngoing(){
        StringBuilder sb = new StringBuilder();
        List<Integer> tmpCurrentSituation = Application.currentSituation;

        for(int i=0;i<tmpCurrentSituation.size();i++){
            sb.append(Application.cars.get(i)+" : "+"-".repeat(tmpCurrentSituation.get(i))+"\n");
        }

        System.out.println(sb);
    }
    // 우승자 출력
    public static void printWinner(){
        List<String> tmpCars = Application.cars;
        List<Integer> tmpCurrentSituation = Application.currentSituation;
        StringBuilder sb = new StringBuilder(tmpCars.get(0));
        int idxMax = 0;

        for(int i=1;i<tmpCars.size();i++){
            String tmpCurrentCarName = tmpCars.get(i);
            int tmpCurrentValue = tmpCurrentSituation.get(i);
            int tmpMaxValue = tmpCurrentSituation.get(idxMax);

            compareValue(tmpCurrentValue, tmpCurrentCarName, tmpMaxValue, idxMax, i, sb);
        }

        System.out.println("최종 우승자 : "+sb);
    }
    // 값 비교
    public static void compareValue(int currentValue, String currentCarName, int maxValue, int maxIdx, int currentIdx, StringBuilder sb){
        if(currentValue > maxValue){
            sb.setLength(0);
            sb.append(currentCarName);
            maxIdx = currentIdx;
        }else if(currentValue == maxValue){
            sb.append(", "+currentCarName);
        }
    }
}

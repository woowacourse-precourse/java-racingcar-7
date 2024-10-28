package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AdvanceAction {
    public Map<String,String> setCarList = new HashMap<>(); // 받아올 변수 선언
    public String [] carList;
    private int maxDistance = 0;
    private String winner;
    public void setFirst(String [] carList){
        this.carList =carList;
        for(String car:carList){
            setCarList.put(car,"");
        }
    }
    public boolean checkUpperFour(){
            int randNum = Randoms.pickNumberInRange(0,9);
            if(randNum >= 4){
                return true;
            }
            return false;
    }

    public void moveCar(int num){
        boolean isUpperFour;
        for(int i=0; i<num; i++){
            System.out.println("실행 결과\n");
            for(int j=0; j<carList.length; j++){
                // 만약 4이상이라면...
                isUpperFour = checkUpperFour();
                if(isUpperFour){
                    String tmp = setCarList.get(carList[j]);
                    tmp += "-";
                    setCarList.put(carList[j],tmp);
                }
                System.out.println(carList[j]+" : "+setCarList.get(carList[j]));
            }

        }

    }

    public void printWinner(){
        maxDistance = setCarList.values().stream().mapToInt(String::length).max().orElse(0);
        StringBuffer stringBuffer = new StringBuffer();
        for(Map.Entry<String,String> entry : setCarList.entrySet()){
            if(entry.getValue().length() == maxDistance){
                if(stringBuffer.length() > 0){
                    stringBuffer.append(", ");
                }
                stringBuffer.append(entry.getKey().toString());
            }
        }
        System.out.println("최종 우승자 : " + stringBuffer.toString());
    }
}

package racingcar;

import java.util.HashMap;
import camp.nextstep.edu.missionutils.Randoms;
public class RaceCar {
    public void start(String[] carNames,int raceTimes){
        int carNums = carNames.length;
        HashMap<String,Integer> carMap = initCars(carNames);

        for(int i=0;i<raceTimes;i++){
            for (String key : carMap.keySet()){
                int value = carMap.get(key);
                int number = randomNumber();
                carMap.put(key,value+number);
            }
            printRace(carMap);
        }

    }

    private void printRace(HashMap<String, Integer> carMap) {
        StringBuilder message = new StringBuilder();
        for(String key : carMap.keySet()){
            message.append(key)
                    .append(" : ")
                    .append("-".repeat(carMap.get(key)))
                    .append("\n");
        }
        System.out.println(message);
    }


    private HashMap<String,Integer> initCars(String[] carNames){
        HashMap<String,Integer> map = new HashMap<>();
        for(String car:carNames){
            map.put(car,0);
        }
        return map;
    }
    private int randomNumber(){
        int num = Randoms.pickNumberInRange(0,9);
        if(num<4){
            return 0;
        }
        return 1;
    }
}

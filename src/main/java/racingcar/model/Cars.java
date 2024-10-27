package racingcar.model;

import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Cars {
    private List<String> carNames;
    private List<Integer> distance;

    public Cars(List<String> carNames){
        this.carNames = carNames;
        List<Integer> begin = Stream.iterate(0, n-> n).limit(carNames.size()).toList();
        List<Integer> newList = new ArrayList<>();
        newList.addAll(begin);
        this.distance = newList;
    }

    public List<String> getCarNames(){
        return this.carNames;
    }
    public List<Integer> getDistance(){
        return this.distance;
    }

    public void setDistance(List<Boolean> isGo) {
       for(int i=0; i<isGo.size(); i++){
           if(isGo.get(i)){
               int pastDistance = this.distance.get(i);
               this.distance.set(i, pastDistance+1);
           }
       }
    }

}

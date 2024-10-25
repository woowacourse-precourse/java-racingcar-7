package racingcar.model;

import java.util.List;

public class Cars {
    private List<String> carNames;
    private List<Integer> distance;

    public Cars(String carName){
        this.carNames.add(carName);
        this.distance.add(0);
    }
    
    public List<String> getCarNames(){
        return this.carNames;
    }
    public List<Integer> getDistance(){
        return this.distance;
    }

    public void setDistance(List<Boolean> isGo){
        for(int i=0; i<isGo.size(); i++){
            if(isGo.get(i)){
                int newDistance = this.distance.get(i)+1;
                this.distance.set(i, newDistance);
            }
        }
    }

}

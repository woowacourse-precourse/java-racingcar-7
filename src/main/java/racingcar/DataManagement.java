package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataManagement {
    private Map<String, String> carData = new HashMap<>();
    private List<String> winners = new ArrayList<>();

    private String inputCarNames;

    public void setCarData(Map<String, String> carData){
        this.carData= carData;
    }

    public Map<String, String> getCarData(){
        return this.carData;
    }

    public void setWinners(List<String> winners){
        this.winners = winners;
    }

    public List<String> getWinners(){
        return this.winners;
    }

    public void setInputCarNames(String inputCarNames){
        this.inputCarNames = inputCarNames;
    }

    public String[] splitCarNames(){
        return this.inputCarNames.split(",");
    }
}

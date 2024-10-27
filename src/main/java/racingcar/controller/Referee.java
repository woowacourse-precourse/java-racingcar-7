package racingcar.controller;


import java.util.List;
import racingcar.model.Cars;

public class Referee {

    public static final String PROMPT = "최종 우승자 : ";
    private final Cars cars;
    private Referee(Cars cars) {
        this.cars = cars;
    }

    public static Referee getInstance(Cars cars){
        return new Referee(cars);
    }
    public String judge(){
        StringBuilder st = new StringBuilder();
        List<String> names = this.cars.getCarNameWithLongestDistance();
        String message = String.join(", ", names);
        st.append(PROMPT).append(message);
        return st.toString();
    }

}

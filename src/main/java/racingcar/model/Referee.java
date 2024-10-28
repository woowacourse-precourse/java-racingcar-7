package racingcar.model;


import java.util.List;
import java.util.stream.IntStream;
import racingcar.common.RandomNumberGenerator;

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

    public void start(int times) {
        for (int i = 0; i < times; i++) {
            cars.moveAll(getRandomNumbers(cars.getSize()));
        }
    }

    private List<Integer> getRandomNumbers(int size){
        return IntStream.range(0,size).mapToObj(
                i -> getRandomNumber()
        ).toList();
    }

    private int getRandomNumber() {
        return RandomNumberGenerator.generate();
    }
}

package racingcar;

import java.util.Arrays;
import java.util.List;

public class CarArgumentResolver {

    public List<String> parse(String parameter) {
        String[] carNameArray = parameter.split(",");
        return Arrays.asList(carNameArray);
    }

}

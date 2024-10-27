package racingcar;

import static racingcar.validation.Validation.validateName;
import static racingcar.validation.Validation.validateSameName;

import java.util.ArrayList;

public class GameService {

    public static ArrayList<String> splitCarName(String carName) {
        ArrayList<String> carNameArray = new ArrayList<>();
        for (String name : carName.split(",", -1)) {
            validateName(name);
            validateSameName(carNameArray, name);
            carNameArray.add(name);
        }
        return carNameArray;
    }

    public static DTO[] registerCarParticipants(ArrayList<String> carNameArray) {
        DTO[] dtoArray = new DTO[carNameArray.size()];
        for (int i = 0; i < dtoArray.length; i++) {
            dtoArray[i] = new DTO(carNameArray.get(i), 0);
        }
        return dtoArray;
    }
}

package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Register {
    public ArrayList<Car> carList;

    public Register() {
        this.carList = new ArrayList<>();
    }

    public void carListUp(ArrayList<String> participateCars) {
        duplicationValidation(participateCars);
        for (String name : participateCars) {
            carList.add(new Car(name));
        }
    }

    public void duplicationValidation(ArrayList<String> duplicateCheck) {
        if (duplicateCheck.size() != duplicateCheck.stream().distinct().count()) {
            throw new IllegalArgumentException("이름이 중복되는 자동차들이 있습니다!");
        }
    }

    public LinkedHashMap<String, Integer> carsMoveCountList() {
        LinkedHashMap<String, Integer> moves = new LinkedHashMap<>();
        for (Car c : carList) {
            moves.put(c.name, c.distance);
        }
        return moves;
    }

    public ArrayList<String> racingWinner() {
        LinkedHashMap<String, Integer> carMoves = carsMoveCountList();
        int maxMove = Collections.max(carMoves.values());

        ArrayList<String> winners = new ArrayList<>();

        for (Map.Entry<String, Integer> m : carMoves.entrySet()) {
            if (m.getValue() == maxMove) {
                winners.add(m.getKey());
            }
        }
        return winners;
    }
}

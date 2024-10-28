package Controller;

import Entity.Result;
import Service.GameManagement;

import java.util.ArrayList;

public class RacingController {
    private GameManagement gm;

    public RacingController() {
        this.gm = new GameManagement();
    }

    /**
     * inputs: 경주에 참여할 자동차 이름들
     * N: 시행 횟수
     */
    public void start(String inputs, String N) {
        String[] names = inputs.split(",");

        ArrayList<String> carNames = new ArrayList<>();
        for (String name: names) {
            name = name.trim();
            if (name.length() < 1 || name.length() > 5) {
                System.out.println("Invalid name!");
                throw new IllegalArgumentException();
            } else {
                carNames.add(name);
            }
        }

        if (Integer.parseInt(N) < 1)
            throw new IllegalArgumentException();
        else if (carNames.size() < 2)
            throw new IllegalArgumentException();

        Result rs = gm.start(carNames, Integer.parseInt(N));
        System.out.println(rs.getResult());
    }
}

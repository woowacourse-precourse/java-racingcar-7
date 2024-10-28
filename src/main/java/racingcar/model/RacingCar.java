package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private String name;
    private StringBuilder results;

    public RacingCar(String name) {
        this.name = name.trim();
        this.results = new StringBuilder();
    }

    public String getName() {
        return name;
    }

    public String getResults() {
        return results.toString();
    }

    public void simulate() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            results.append("-"); // 결과 누적
        }
    }

    public int countDashes() {
        return results.length(); // "-"의 개수 반환
    }
}


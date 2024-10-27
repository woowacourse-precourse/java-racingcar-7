package racingcar.model.car;

import racingcar.model.decisionNum.DecisionNum;

public class Car {

    private Name name;
    private Integer totalForwordCount;
    private Distance distance;

    public Car(String name) {
        this.name = new Name(name);
        this.totalForwordCount = 0;
        this.distance = new Distance();
    }

    public void moveCar() {

        //앞으로 갈지 안 갈지 결정하는 숫자
        int decision = GenerateDecisionNum();

        //전진하면 전체 전진횟수 증가
        if (isGo(decision)) {
            totalForwordCount++;
        }

        //거리 문자열 붙이기
        for (int i = 0; i < decision; i++) {
            distance.increaseDistance();
        }

    }

    public void endRacing() {
        distance.resetDistance();
    }

    private int GenerateDecisionNum() {
        return DecisionNum.GenerateDecisionNum();
    }

    private boolean isGo(int decisionNum) {
        return DecisionNum.isGo(decisionNum);
    }

    public Name getName() {
        return name;
    }

    public Distance getDistance() {
        return distance;
    }

    public Integer getTotalForwordCount() {
        return totalForwordCount;
    }

}

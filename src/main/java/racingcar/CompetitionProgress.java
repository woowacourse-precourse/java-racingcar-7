package racingcar;

import java.util.ArrayList;

public class CompetitionProgress {

    public class Car {

        private String name;
        private int moveDistance;
        private ArrayList<Integer> moveLog=new ArrayList<>();


        public Car(String name,int moveDistance) {
            this.name=name;
            this.moveDistance=moveDistance;
        }

        public String getName() {
            return name;
        }

        public int getMoveDistance() {
            return moveDistance;
        }

        public void move() {
            this.moveDistance+=1;
        }

        public void updateMoveLog() {
            moveLog.add(moveDistance);
        }
    }
}

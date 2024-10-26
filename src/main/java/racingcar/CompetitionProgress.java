package racingcar;

import java.util.ArrayList;
import java.util.Random;

public class CompetitionProgress {

    static private ArrayList<Car> raceMember;
    public class Car {

        private String name;
        private int moveDistance=0;
        private ArrayList<Integer> moveLog=new ArrayList<>();


        public Car(String name) {
            this.name=name;

        }

        public String getName() {
            return name;
        }

        public int getMoveDistance() {
            return moveDistance;
        }

        public ArrayList<Integer> getMoveLog() {
            return moveLog;
        }

        public void move() {
            this.moveDistance+=1;
        }

        public void updateMoveLog() {
            moveLog.add(moveDistance);
        }
    }

    CompetitionProgress(String[] inputRaceMember,int playCount) {

        for(String member : inputRaceMember) {
            Car car=new Car(member);
            raceMember.add(car);
        }

        for(int i=0;i<playCount;i++) {
            updateRaceMember();

        }
    }

    ArrayList<Car> getRaceMember() {
        return raceMember;
    }

    static void updateRaceMember() {

        Random random = new Random();
        int randomValue=random.nextInt(10);

        for(Car member :raceMember) {
            if(randomValue >=4) {
                member.move();
                member.updateMoveLog();
            } else {
                member.updateMoveLog();
            }
        }
    }
}

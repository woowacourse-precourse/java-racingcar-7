package racingcar;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class CompetitionProgress {

    static private ArrayList<Car> raceMember;
    static private ArrayList<Car> raceWinner;

    CompetitionProgress(ParseInput parseinput,int playCount) {

        String[] inputRaceMember=parseinput.getRaceMember();

        raceMember=new ArrayList<>();

        for(String member : inputRaceMember) {
            Car car=new Car(member);
            raceMember.add(car);
        }

        for(int i=0;i<playCount;i++) {
            updateRaceMember();
        }

        makeRaceWinner(playCount-1);

    }

    void makeRaceWinner(int raceResultCount) {

        raceWinner=new ArrayList<>();
        int maxDistance=-1;
        for(Car car : raceMember) {

            int moveDistance=car.getMoveDistance();
            if(maxDistance < moveDistance) {
                //그전까지 저장하던 raceWinner 초기화 후 새로운 최대 거리를 가진 우승자 저장
                raceWinner.clear();
                maxDistance=moveDistance;
                raceWinner.add(car);
            } else if (maxDistance == moveDistance) {
                //최대 거리를 가진 참여자인 경우 raceWinner 그룹에 추가
                raceWinner.add(car);
            }

        }
    }

    ArrayList<Car> getRaceWinner() {
        return raceWinner;
    }
    ArrayList<Car> getRaceMember() {
        return raceMember;
    }

    static void updateRaceMember() {

        for(Car member :raceMember) {

            int randomValue=Randoms.pickNumberInRange(0, 9);

            if(randomValue >=4) {
                member.move();
                member.updateMoveLog();
            } else {
                member.updateMoveLog();
            }
        }
    }
}

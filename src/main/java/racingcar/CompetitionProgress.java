package racingcar;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class CompetitionProgress {

    static private ArrayList<Car> raceMember;
    static private ArrayList<Car> raceWinner;

    CompetitionProgress(ParseInput parseinput,int playCount) {

        String[] inputRaceMember=parseinput.getRaceMember();

        //string[] 에 들어있는 출전 자동차를 arraylist<Car> 형태로 변환
        raceMember=convertStringToCar(inputRaceMember);

        //경기 진행
        for(int i=0;i<playCount;i++) {
            updateRaceMember();
        }

        raceWinner=makeRaceWinner();

    }

    ArrayList<Car> convertStringToCar(String[] inputRaceMember) {

        ArrayList<Car> tempRaceMember=new ArrayList<>();
        for(String member : inputRaceMember) {
            Car car=new Car(member);
            tempRaceMember.add(car);
        }

        return tempRaceMember;
    }

    ArrayList<Car> makeRaceWinner() {

        ArrayList<Car> tempRaceWinner=new ArrayList<>();
        int maxDistance=-1;
        for(Car car : raceMember) {

            int moveDistance=car.getMoveDistance();
            if(maxDistance < moveDistance) {
                //그전까지 저장하던 raceWinner 초기화 후 새로운 최대 거리를 가진 우승자 저장
                tempRaceWinner.clear();
                maxDistance=moveDistance;
                tempRaceWinner.add(car);
            } else if (maxDistance == moveDistance) {
                //최대 거리를 가진 참여자인 경우 raceWinner 그룹에 추가
                tempRaceWinner.add(car);
            } else {
                // 우승자 후보가 아닌 경우
            }

        }

        return tempRaceWinner;
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
            //4이상 값이 나온경우 1칸 전진 그후 이번 시행으로 이동한 거리를 moveLog에 저장
            if(randomValue >=4) {
                member.move();
                member.updateMoveLog();
            } else {
                member.updateMoveLog();
            }
        }
    }
}

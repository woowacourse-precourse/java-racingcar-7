package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import constants.PrintConstants;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class CarGame {
    int executeNum;
    String readNames;
    String[] playUsers;

    public CarGame() {}

    public void start(){
        DataInfo[] dataInfoArray;
        Parsing parsing = new Parsing();

        //User Names input
        System.out.println(PrintConstants.PRINT_IN_NAME_MSG);
        this.readNames = readLine();

        //Game Play set
        System.out.println(PrintConstants.PRINT_IN_CNT_MSG);
        this.executeNum = parsing.strToInt(readLine());

        //Split Play Users
        this.playUsers = parsing.spliteStr(this.readNames);

        //User Data Object init
        dataInfoArray = new DataInfo[this.playUsers.length];

        for (int i = 0; i < this.playUsers.length; i++) {
            dataInfoArray[i] = new DataInfo();
            dataInfoArray[i].initStatus(playUsers[i]);
        }

        System.out.println();
        System.out.println(PrintConstants.PRINT_RESULT_MSG);

        //Start Game
        for (int round = 0; round < this.executeNum; round++) {

            for (int carNum = 0; carNum < this.playUsers.length; carNum++) {
                dataInfoArray[carNum].move();
                System.out.println(dataInfoArray[carNum].getUserName() + " : " + parsing.countToDash(dataInfoArray[carNum].getMoveCount()) );

            }
            System.out.println();

        }

        //최대거리
        int winnerIndex = 0;
        ArrayList<String> winners = new ArrayList<String>();

        for (int i = 1; i < dataInfoArray.length; i++) {
            if (dataInfoArray[i].getMoveCount() > dataInfoArray[winnerIndex].getMoveCount()) {
                winnerIndex = i;
            }
        }

        // 동점자
        int maxMoveCount = dataInfoArray[winnerIndex].getMoveCount();

        for (int i = 0; i < dataInfoArray.length; i++) {
            if (dataInfoArray[i].getMoveCount() == maxMoveCount) {
                winners.add(dataInfoArray[i].getUserName());
            }
        }

        System.out.println( PrintConstants.PRINT_OUT_MSG + String.join(", ", winners));

    }
}

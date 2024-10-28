package utils;

import constant.Constants;
import inspector.InspectName;
import java.util.ArrayList;
import java.util.Arrays;

public class ContentParser {
    public static ArrayList<String> parsingContentToGroup(String inputContent){
        ArrayList<String> group = splitting(inputContent);

        for(int i = 0; i < group.size(); i++){
            group.set(i, group.get(i).strip()); //i번 index의 원소에 있는 값의 공백을 제거하고 삽입
        }

        inspectingPlayerName(group);
        return group;
    }

    private static ArrayList<String> splitting(String targetContent){
        return new ArrayList<>(Arrays.stream(targetContent.split(Constants.CONTENT_DELIMITER)).toList());
    }


    private static void inspectingPlayerName(ArrayList<String> playerGroup){
        InspectName inspectName = new InspectName();
        inspectName.inspectingInvalidName(playerGroup);
    }
}

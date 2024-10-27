package utils;

import constant.Constants;
import inspector.InspectName;
import java.util.ArrayList;
import java.util.Arrays;

public class ContentParser {
    public static ArrayList<String> parsingContentToGroup(String inputContent){
        ArrayList<String> splittedGroup = splitting(inputContent);
        for(int i = 0; i < splittedGroup.size(); i++){
            splittedGroup.set(i,splittedGroup.get(i).strip());
        }
        inspectingPlayerName(splittedGroup);
        return splittedGroup;
    }

    private static ArrayList<String> splitting(String targetContent){
        return new ArrayList<String>(Arrays.stream(targetContent.split(Constants.CONTENT_DELIMITER)).toList());
    }


    private static void inspectingPlayerName(ArrayList<String> playerGroup){
        InspectName inspectName = new InspectName();
        inspectName.inspecting(playerGroup);
    }
}

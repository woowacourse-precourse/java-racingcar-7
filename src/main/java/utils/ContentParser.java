package utils;

import constant.Constants;
import inspector.InspectName;

public class ContentParser {
    public static String[] parsingContentToGroup(String inputContent){
        String[] splittedGroup = splitting(inputContent);
        for(int i = 0; i < splittedGroup.length; i++){
            splittedGroup[i] = splittedGroup[i].strip();
        }
        inspectingPlayerName(splittedGroup);
        return splittedGroup;
    }

    private static String[] splitting(String targetContent){
        return targetContent.split(Constants.CONTENT_PASRE_DELIMITER);
    }


    private static void inspectingPlayerName(String[] playerGroup){
        InspectName inspectName = new InspectName();
        inspectName.inspecting(playerGroup);
    }
}

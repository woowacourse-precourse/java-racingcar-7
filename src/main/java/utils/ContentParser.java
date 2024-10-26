package utils;

import constant.Constants;
import inspector.InspectName;

public class ContentParser {
    public static String[] parsingContentToGroup(String targetContent){
        String[] parsedGroup = splitting(targetContent);
        for(int i = 0; i < parsedGroup.length; i++){
            parsedGroup[i] = removingWhiteSpace(parsedGroup[i]);
        }
        inspectingPlayerName(parsedGroup);
        return parsedGroup;
    }
    private static String[] splitting(String targetContent){
        return targetContent.split(Constants.CONTENT_PASRE_DELIMITER);
    }

    private static String removingWhiteSpace(String targetContent){
        return targetContent.strip();
    }

    private static void inspectingPlayerName(String[] playerGroup){
        InspectName inspectName = new InspectName();
        inspectName.inspecting(playerGroup);
    }
}

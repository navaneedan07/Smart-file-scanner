import java.nio.file.Path;
import java.util.*;

public class UserProfileGenerator {
    
    public static String generateProfile(Map<String, List<Path>> categorized) {
        StringBuilder profile = new StringBuilder();

        int docCount = count(categorized,"Documents");
        int imgCount = count(categorized, "Images");
        int audioCount = count(categorized,"Audio");
        int videoCount = count(categorized,"Videos");
        int codeCount = count(categorized,"Code");
        int otherCount = count(categorized,"Others");

        if(docCount > imgCount && docCount > codeCount) {
            profile.append("Heavy document usage detected\n");
        }

        if(imgCount>50) {
            profile.append("Lots of images found - Maybe a photo designer\n");
        }

        if(videoCount>10) {
            profile.append("Video consumption is high\n");
        }

        if(audioCount>10) {
            profile.append("Music/audio files are present\n");
        }

        if(otherCount>15) {
            profile.append("Miscellaneous file types are large in number\n");
        }

        if(profile.length() == 0) {
            profile.append("Balanced and clean system");
        }
        return profile.toString();
    }

    private static int count(Map<String , List<Path>> map, String key) {
        return map.containsKey(key) ? map.get(key).size() : 0;
    }
}

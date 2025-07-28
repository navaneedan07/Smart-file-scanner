import java.nio.file.Path;
import java.util.*;
public class CleanSuggestion {
    public static List<String> suggest(Map<String, List<Path>> categorized) {
        List<String> tips = new ArrayList<>();

        for(String category : categorized.keySet()) {
            int count = categorized.get(category).size();

            switch(category) {
                case "Videos": if(count>10) tips.add("You have too many videos! Consider deleting some of it"); break;
                case "Images": if(count>50) tips.add("Images folder is crowded! Try cleaning the bin"); break;
                case "Documents": if(count>30) tips.add("Too many documents : Delete unused docs"); break;
                case "Others" : if(count>20) tips.add("Junk/Unknown type files are more : Review it"); break;
                default: break;
            }
            if(tips.isEmpty()) {
                tips.add("Your system looks fine");
            }
        }
        return tips;
    }
}

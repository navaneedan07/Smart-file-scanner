import java.nio.file.Path;
import java.util.*;

public class FileTypeAnalyzer {
    public static Map<String, List<Path>> categorizeFiles(List<Path> files) {
        Map<String, List<Path>> categorized = new HashMap<>();

        String[] docType = {"pdf","doc","docx","txt"};
        String[] imgType = {"jpg","jpeg","png","gif","bmp"};
        String[] audioType = {"mp3","wav","aac"};
        String[] videoType = {"mp4","avi","mkv","mov"};
        String[] codeType = {"java","cpp","c","py","js","html","css"};

        for(Path file : files) {
            String fileName = file.getFileName().toString().toLowerCase();
            String extension = getExtension(fileName);
            String category = getCategory(extension,docType, imgType, audioType, videoType, codeType);

            categorized.putIfAbsent(category, new ArrayList<>());
            categorized.get(category).add(file);
        }
        return categorized;
    }

    private static String getExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        if(dotIndex == -1 || dotIndex == fileName.length() - 1)
            return "";
        return fileName.substring(dotIndex+1);
    }

    private static String getCategory(String ext, String[] doc, String[] img, String[] audio, String[] video, String[] code) {
        if(Arrays.asList(doc).contains(ext)) return "Documents";
        if(Arrays.asList(img).contains(ext)) return "Images";
        if(Arrays.asList(audio).contains(ext)) return "Audio";
        if(Arrays.asList(video).contains(ext)) return "Videos";
        if(Arrays.asList(code).contains(ext)) return "Code";
        return "Others";
    }
}

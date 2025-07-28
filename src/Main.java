import java.util.*;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("---Smart file scanner---");
        System.out.println("Enter directory path to scan (else leave empty for default) : ");
        String inputPath = sc.nextLine().trim();
        String pathToScan = inputPath.isEmpty() ? System.getProperty("user.home") : inputPath;

        List<Path> files = FileScanner.scanDirectory(pathToScan);

        Map<String, List<Path>> categorized = FileTypeAnalyzer.categorizeFiles(files);

        String profile = UserProfileGenerator.generateProfile(categorized);

        List<String> cleanTips = CleanSuggestion.suggest(categorized);

        System.out.println("\n---File Summary---");
        categorized.forEach((type, fileList) -> {
            System.out.println(type+" : "+ fileList.size()+ " files");
        });

        System.out.println("\n---User profile---");
        System.out.println(profile);

        System.out.println("---Cleaner tips---");
        cleanTips.forEach(System.out::println);
        sc.close();
    }
}
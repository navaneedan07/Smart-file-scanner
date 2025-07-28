import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class FileScanner {
    public static List<Path> scanDirectory(String path) {
        List<Path> fileList = new ArrayList<>();
        try {
            Path startPath = Paths.get(path);

            if(!Files.exists(startPath)) {
                System.out.println("Path does not exist : "+path);
                return fileList;
            }
            Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file,BasicFileAttributes attri) {
                    if(Files.isRegularFile(file)) {
                        fileList.add(file);
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file,IOException exc) {
                    return FileVisitResult.CONTINUE;
                }
            });
        }
        catch(IOException ex) {
            System.out.println("Error while scanning : "+ex.getMessage());
        }

        return fileList;
    }
}

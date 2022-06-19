import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

public class PhotosMover {

    public void movePhotos(Set<File> rafs, String rafsTarget) {
        System.out.println("RAFs to move: " + rafs.size());
        createTargetDirectoryIfNotExists(rafsTarget);

        for (final File raf : rafs) {
            final String oldPath = raf.getAbsolutePath();
            final String rafName = raf.getName();
            final String replacement = rafsTarget + "\\" + rafName;
            final String newPath = oldPath.replace(oldPath, replacement);
            move(oldPath, newPath);
        }
    }

    private void createTargetDirectoryIfNotExists(String rafsTarget) {
        Path rafsPath = Paths.get(rafsTarget);

        try {
            Files.createDirectories(rafsPath);
        } catch (IOException e) {
            System.err.println("Cannot create directory!");
            throw new RuntimeException(e);
        }

    }

    private void move(String oldPath, String newPath) {
        final Path source = Paths.get(oldPath);
        final Path target = Paths.get(newPath);

        System.out.println("Moving: \"" + oldPath + "\" to \"" + newPath + "\"");
        try {
            Files.move(source, target);
        } catch (IOException e) {
            System.err.println("Unable to move one or more files!");
            throw new RuntimeException(e);
        }
    }

}

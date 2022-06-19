import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class PhotoMatcher {
    public List<File> getMatchedRafs(Set<File> jpgs, Set<File> rafs, PhotosLoader loader) {
        List<File> matchRafs = new ArrayList<>();
        for (final File file : jpgs) {
            final String name = getFileNameWithoutExtension(file);
            Optional<File> result = rafs
                    .stream()
                    .filter(element -> loader.nameFilter(element, name))
                    .findAny();
            result.ifPresent(matchRafs::add);
        }

        System.out.println("Matched RAFs count: " + matchRafs.size());

        return matchRafs;
    }

    private String getFileNameWithoutExtension(File file) {
        final String fullName = file.getName();
        final int dotIndex = fullName.indexOf(".");
        return fullName.substring(0, dotIndex);
    }

}

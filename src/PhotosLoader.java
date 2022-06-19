import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PhotosLoader {

    public Set<File> getJpgs(List<File> files) {
        return files
                .stream()
                .filter(file -> fileFilter(file, ".JPG"))
                .collect(Collectors.toSet());
    }

    public Set<File> getRafs(List<File> files) {
        return files
                .stream()
                .filter(file -> fileFilter(file, ".RAF"))
                .collect(Collectors.toSet());
    }

    public boolean nameFilter(File file, String name) {
        return file.getName().contains(name);
    }

    private boolean fileFilter(File file, String extension) {
        final String name = file.getName();
        return name.contains(extension);
    }

}

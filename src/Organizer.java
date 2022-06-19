import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Organizer {
    final PhotosLoader loader;
    final Set<File> jpgs;
    final Set<File> rafs;

    Organizer(String path) {
        final File folder = new File(path);
        final List<File> files = loadFiles(folder);

        this.loader = new PhotosLoader();
        this.jpgs = loader.getJpgs(files);
        this.rafs = loader.getRafs(files);
    }

    public void organize(final String rafsTarget) {
        System.out.println("JPGs count: " + jpgs.size());
        System.out.println("All RAFs count: " + rafs.size());

        removeOrphanRafs();
        final PhotosMover mover = new PhotosMover();
        mover.movePhotos(rafs, rafsTarget);
    }

    private List<File> loadFiles(final File folder) {
        File[] files = folder.listFiles();
        File[] nonNullFiles = Objects.requireNonNull(files);
        return Arrays.asList(nonNullFiles);
    }

    private void removeOrphanRafs() {
        final PhotoMatcher matcher = new PhotoMatcher();
        final List<File> matchRafs = matcher.getMatchedRafs(jpgs, rafs, loader);
        matchRafs.forEach(rafs::remove);
    }

}

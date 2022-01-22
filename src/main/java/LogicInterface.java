import java.util.List;

public interface LogicInterface {
    List<String> sortStringFiles(List<String>[] readedFiles, int sortType);
    List<Integer> sortIntegerFiles(List<Integer>[] sortedFiles, int sortType);
}

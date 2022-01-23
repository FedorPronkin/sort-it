import java.util.List;

public interface LogicInterface<T extends Comparable<T>> {
    List<String> sortFiles(List<T>[] readedFiles, int sortType);
}

import java.util.LinkedList;
import java.util.List;

public interface LogicInterface<T> {
    List<String> sortFiles(List<T>[] readedFiles, int sortType);
}

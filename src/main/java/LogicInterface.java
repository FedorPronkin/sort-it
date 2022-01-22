import java.util.LinkedList;
import java.util.List;

public interface LogicInterface {
    List<String> sortStringFiles(LinkedList<String>[] readedFiles, String sortType);
    List<Integer> sortIntegerFiles(LinkedList<Integer>[] sortedFiles, String sortType);
}

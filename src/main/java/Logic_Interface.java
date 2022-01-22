import java.util.LinkedList;
import java.util.List;

public interface Logic_Interface {
    List<String> sortStringFiles(LinkedList<String>[] readFiles, String sortType);
    List<Integer> sortIntegerFiles(LinkedList<Integer>[] sortedFiles, String sortType);
}

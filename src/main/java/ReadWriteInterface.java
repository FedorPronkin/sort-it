import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public interface ReadWriteInterface<T> {

    List<T>[] readAllToString(ArrayList<String> inputFiles, int sortType);
    void writeToFile(List<String> result, String outFile) throws IOException;

}

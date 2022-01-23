import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public interface ReadWriteInterface<T> {

    boolean sort(ArrayList<String> inputFiles, int sortType, String outFile);

}

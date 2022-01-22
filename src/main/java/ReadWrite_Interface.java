import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public interface ReadWrite_Interface {

    ShowMessage showMessage = new ShowMessage();

    LinkedList<String>[] readAllToString(ArrayList<String> inputFiles, String sortType);
    LinkedList<Integer>[] readAllToInteger(ArrayList<String> inputFiles, String sortType);
    void writeToFile(List<String> result, String outFile) throws IOException;

}

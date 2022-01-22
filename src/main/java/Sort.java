import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.lang.System.exit;

public class Sort {
    public static void main(String[] args) {

        ShowMessage showMessage = new ShowMessage();
        ReadWrite readWrite = new ReadWrite();
        Logic logic = new Logic();

        String sortType = "-a";
        String dataType = null;
        String outputFile = null;
        ArrayList<String> inputFiles = new ArrayList<>();

        if (args.length != 0) {
            int i = 0;
            while (args[i].contains("-")) {
                if (args[i].equals("-a") || args[i].contains("-d")) {
                    sortType = args[i];
                } else if (args[i].equals("-i") || args[i].equals("-s")) {
                    dataType = args[i];
                }

                i++;
                if (i == args.length) {
                    break;
                }
            }

            if (dataType == null) {
                showMessage.showOutOfDataTypeError();
                exit(1);
            } else {
                try {
                    outputFile = args[i];
                    for (++i; i < args.length; i++) {
                        inputFiles.add(args[i]);
                    }
                    if (inputFiles.size() == 0) {
                        showMessage.showNoInputFileMessage();
                        exit(1);
                    }
                } catch (ArrayIndexOutOfBoundsException exception) {
                    showMessage.showNoOutFileMessage();
                    showMessage.showNoInputFileMessage();
                    exit(1);
                }
            }

            List<String> result = new LinkedList<>();
            if(dataType.equals("-s")) {

                LinkedList<String>[] allFilesReaded = readWrite.readAllToString(inputFiles, sortType);
                result = logic.sortStringFiles(allFilesReaded, sortType);

            } else {

                LinkedList<Integer>[] allFilesReaded = readWrite.readAllToInteger(inputFiles, sortType);
                for(int copy : logic.sortIntegerFiles(allFilesReaded, sortType)){
                    result.add(Integer.toString(copy));
                }

            }

            try {
                readWrite.writeToFile(result, outputFile);
                showMessage.showWritingSuccessMessage();
            } catch (IOException error){
                showMessage.showWriteErrorMessage(error.getMessage());
            }

        } else {
            showMessage.showNoParametersMessage();
            exit(1);
        }
    }

}

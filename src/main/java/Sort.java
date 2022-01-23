import java.io.File;
import java.util.ArrayList;

import static java.lang.System.exit;

public class Sort {

    final static String ASCENDING = "-a";
    final static String DESCENDING = "-d";
    final static String TYPESTRING = "-s";
    final static String TYPEINTEGER = "-i";

    static ShowMessageInterface showMessage = new ShowMessage();

    public static void main(String[] args) {


        int sortType = 0;
        String dataType = null;
        String outputFile = null;
        ArrayList<String> inputFiles = new ArrayList<>();

        if (args.length != 0) {
            int i = 0;
            while (args[i].contains("-")) {
                if (args[i].equals(ASCENDING)) {
                    if (sortType == 0) {
                        sortType = -1;
                    } else {
                        showMessage.showTooManySortParams();
                    }
                } else if (args[i].contains(DESCENDING)) {
                    if (sortType == 0) {
                        sortType = 1;
                    } else {
                        showMessage.showTooManySortParams();
                    }
                } else if (args[i].equals(TYPEINTEGER) || args[i].equals(TYPESTRING)) {
                    if (dataType != null) {
                        showMessage.showTooManyDataTypeParams();
                    } else {
                        dataType = args[i];
                    }
                } else {
                    showMessage.showUnknownParams(args[i]);
                }
                i++;
                if (i == args.length) {
                    break;
                }
            }

            if (sortType == 0) {
                sortType = -1;
            }

            if (dataType == null) {
                showMessage.showOutOfDataTypeError();
                exit(1);
            } else {
                outputFile = args[i];
                inputFiles = readInputFiles(i, args);
            }

            //Запуск сортировки и вывод результата
            extracted(sortType, dataType, outputFile, inputFiles);

        } else {
            showMessage.showNoParametersMessage();
            exit(1);
        }
    }

    private static void extracted(int sortType, String dataType, String outputFile, ArrayList<String> inputFiles) {
        if (dataType.equals(TYPESTRING)) {

            ReadWriteInterface readWrite = new ReadWrite<>(String.class);

            if (readWrite.sortFiles(inputFiles, sortType, outputFile)) {
                showMessage.showWritingSuccessMessage();
            } else {
                showMessage.showOutFileIsEmpty();
            }


        } else {
            ReadWrite<Integer> readWrite = new ReadWrite<>(Integer.class);

            if (readWrite.sortFiles(inputFiles, sortType, outputFile)) {
                showMessage.showWritingSuccessMessage();
            } else {
                showMessage.showOutFileIsEmpty();
            }
        }
    }

    private static ArrayList<String> readInputFiles(int argPosition, String[] args) {
        ArrayList<String> inputFiles = new ArrayList<>();
        try {
            for (++argPosition; argPosition < args.length; argPosition++) {
                File check = new File(args[argPosition]);
                if (check.exists()) {
                    inputFiles.add(args[argPosition]);
                } else {
                    showMessage.showNoFilesMessage(args[argPosition]);
                }
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
        return inputFiles;
    }
}

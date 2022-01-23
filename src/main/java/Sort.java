import java.io.File;
import java.util.ArrayList;

import static java.lang.System.exit;

public class Sort {

    final static String ASCENDING = "-a";
    final static String DESCENDING = "-d";
    final static String TYPESTRING = "-s";
    final static String TYPEINTEGER = "-i";

    public static void main(String[] args) {

        ShowMessageInterface showMessage = new ShowMessage();

        int sortType = 0;
        String dataType = null;
        String outputFile = null;
        ArrayList<String> inputFiles = new ArrayList<>();

        if (args.length != 0) {
            int i = 0;
            while (args[i].contains("-")) {
                if (args[i].equals(ASCENDING)){
                    if(sortType == 0) {
                        sortType = -1;
                    }else{
                        showMessage.showTooManySortParams();
                    }
                } else if (args[i].contains(DESCENDING)) {
                    if(sortType == 0) {
                            sortType = 1;
                         }else{
                           showMessage.showTooManySortParams();
                         }
                    } else if (args[i].equals(TYPEINTEGER) || args[i].equals(TYPESTRING)){
                            if(dataType != null){
                                showMessage.showTooManyDataTypeParams();
                            }else {
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

            if (dataType == null) {
                showMessage.showOutOfDataTypeError();
                exit(1);
            } else {
                try {
                    outputFile = args[i];

                    for (++i; i < args.length; i++) {
                        File check = new File(args[i]);
                        if(check.exists()) {
                            inputFiles.add(args[i]);
                        } else {
                            showMessage.showNoFilesMessage(args[i]);
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
            }

            if(dataType.equals(TYPESTRING)) {

                 ReadWriteInterface readWrite = new ReadWrite<>(String.class);

                 if(readWrite.sort(inputFiles, sortType, outputFile)){
                     showMessage.showWritingSuccessMessage();
                 } else{
                     showMessage.showOutFileIsEmpty();
                 }


            } else {
                ReadWrite<Integer> readWrite = new ReadWrite<>(Integer.class);

                if(readWrite.sort(inputFiles, sortType, outputFile)){
                    showMessage.showWritingSuccessMessage();
                }else{
                    showMessage.showOutFileIsEmpty();
                }
            }

        } else {
            showMessage.showNoParametersMessage();
            exit(1);
        }
    }
}

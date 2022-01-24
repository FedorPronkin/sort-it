import java.io.*;
import java.util.ArrayList;

import static java.lang.System.exit;

public class ReadWrite<T extends Comparable<T>> implements ReadWriteInterface {

    ShowMessageInterface showMessage = new ShowMessage();

    private final Class<T> myClass;

    public ReadWrite(Class<T> myClass) {
        this.myClass = myClass;
    }

    public boolean sortFiles(ArrayList<String> inputFiles, int sortType, String outFile) {

        ArrayList<BufferedReader> readers = new ArrayList<>(inputFiles.size());
        ArrayList<T> data = new ArrayList<>();
        int writtenStrings = 0;

        for (String inputFile : inputFiles) {
            try {
                readers.add(new BufferedReader(new FileReader(inputFile)));
            } catch (FileNotFoundException e) {
                showMessage.showFileNotFoundMessage(inputFile);
            }
        }

        for (int j = 0; j < inputFiles.size(); j++) {
            while (true) {
                try {
                    T gotData = readLine(readers.get(j));
                    if (gotData != null && myClass.equals(String.class) && (gotData.equals(" ") || gotData.equals(""))) {
                        showMessage.showDataErrorMessage();
                    } else
                        data.add(gotData);
                        break;
                } catch (ClassCastException e) {
                    showMessage.showDataErrorMessage();
                }
            }
        }

        try {
            File file = new File(outFile);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            while (checkData(data)) {
                T value = data.get(0);
                int position = 0;

                for (int i = 1; i < data.size(); i++) {
                    if (data.get(i) != null) {
                        value = data.get(i);
                        position = i;
                        break;
                    }
                }

                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i) != null)
                        if (value.compareTo(data.get(i)) * sortType < 0) {
                            value = data.get(i);
                            position = i;
                        }
                }

                writer.write(value + "\n");
                writtenStrings++;

                //Чтение строки, замещающей записанную в файл, с проверкой сортировки
                extracted(inputFiles, sortType, readers, data, position);

            }
            writer.close();
        } catch (IOException e) {
            showMessage.showWriteErrorMessage(e.getMessage());
            return false;
        }

        for (BufferedReader file : readers) {
            try {
                file.close();
            } catch (IOException e) {
                showMessage.showClosingFilesError(e.getMessage());
                exit(1);
            }
        }
        return writtenStrings != 0;
    }

    private void extracted(ArrayList<String> inputFiles, int sortType, ArrayList<BufferedReader> readers, ArrayList<T> data, int position) {
        while (true) {
            T gotData;
            try {
                gotData = readLine(readers.get(position));
                if (gotData == null) {
                    data.set(position, null);
                    break;
                } else if (myClass.equals(String.class) && (gotData.equals(" ") || gotData.equals(""))) {
                    showMessage.showDataErrorMessage();
                } else if (data.get(position).compareTo(gotData) * sortType > 0) {
                    data.set(position, gotData);
                    break;
                } else {
                    showMessage.showNotSortedMessage((String) gotData, inputFiles.get(position));
                }
            } catch (ClassCastException e) {
                showMessage.showDataErrorMessage();
            }
        }
    }

    private T readLine(BufferedReader reader) throws ClassCastException  {
        try {
            String gotString = reader.readLine();
            if (gotString == null) {
                return null;
            }
            if (myClass.equals(Integer.class)) {
                return myClass.cast(Integer.parseInt(gotString));
            } else {
                return myClass.cast(gotString);
            }
        } catch (IOException e) {
            showMessage.showReadingErrorMessage(e.getMessage());
        } catch (NumberFormatException e){
            showMessage.showDataErrorMessage();
        }
        return null;
    }

    private boolean checkData(ArrayList<T> data) {
        for (T datum : data) {
            if (datum != null) {
                return true;
            }
        }
        return false;
    }

}

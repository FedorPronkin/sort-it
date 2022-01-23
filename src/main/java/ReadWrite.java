import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReadWrite<T extends Comparable<T>> implements ReadWriteInterface<T> {

    ShowMessageInterface showMessage = new ShowMessage();

    public boolean sort(ArrayList<String> inputFiles, int sortType, String outFile) {

        ArrayList<BufferedReader> readers = new ArrayList<>(inputFiles.size());
        ArrayList<T> data = new ArrayList<>();


        for (String inputFile : inputFiles) {
            try {
                readers.add(new BufferedReader(new FileReader(inputFile)));
            } catch (FileNotFoundException e) {
                showMessage.showFileNotFoundMessage(inputFile);
            }
        }


        for (int j = 0; j < inputFiles.size(); j++) {
          data.add(readLine(readers.get(j)));
        }

        try {
            File file = new File(outFile);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            while(checkData(data)){
                T value = data.get(0);
                int position = 0;

                for(int i = 1; i < data.size(); i++){
                    if(data.get(i) != null) {
                        value = data.get(i);
                        position = i;
                    }
                }

                for(int i = 0; i < data.size(); i ++) {
                    if(data.get(i) != null)
                    if (value.compareTo(data.get(i)) * sortType < 0) {
                        value = data.get(i);
                        position = i;
                    }
                }

                writer.write(value + "\n");

                while(true) {
                    T readed = readLine(readers.get(position));
                    if(readed == null) {
                        data.set(position, null);
                        break;
                    } else if(data.get(position).compareTo(readed) * sortType > 0) {
                        data.set(position, readed);
                        break;
                    }else {
                        showMessage.showNotSortedMessage((String)readed, inputFiles.get(position));
                        }
                    }

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
                e.printStackTrace();
            }
        }

        return true;
    }

    private T readLine(BufferedReader reader){

        try {
            String readedString = reader.readLine();
            if(readedString == null){
                return null;
            }
            if (readedString.contains(" ") || readedString.equals("")) {
                showMessage.showDataErrorMessage(readedString);
            }
            return (T)readedString;
        } catch (IOException e) {
            showMessage.showReadingErrorMessage(e.getMessage());
            return null;
        }
    }

    private boolean checkData(ArrayList<T> data){
        for (T datum : data) {
            if (datum != null) {
                return true;
            }
        }
       return false;
    }

}

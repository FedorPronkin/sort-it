import java.io.*;
import java.util.ArrayList;

public class ReadWrite<T extends Comparable<T>> implements ReadWriteInterface {

    ShowMessageInterface showMessage = new ShowMessage();

    private final Class<T> myClass;

    public ReadWrite(Class<T> myClass) {
        this.myClass = myClass;
    }

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
                    T gotData = readLine(readers.get(position));

                    if(gotData == null) {
                        data.set(position, null);
                        break;
                    } else if(data.get(position).compareTo(gotData) * sortType > 0) {
                        data.set(position, gotData);
                        break;
                    }else {
                         showMessage.showNotSortedMessage((String) gotData, inputFiles.get(position));
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
            if (readedString.trim().isEmpty()) {
                showMessage.showDataErrorMessage(readedString);
            }
            if(myClass.isInstance(Integer.class)) {
                return myClass.cast(Integer.parseInt(readedString));
            }
            else{
                return myClass.cast(readedString);
            }
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

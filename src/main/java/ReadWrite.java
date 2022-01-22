import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReadWrite<T extends Comparable<T>> implements ReadWriteInterface<T> {

    ShowMessageInterface showMessage = new ShowMessage();

    public List<T>[] readAllToString(ArrayList<String> inputFiles, int sortType) {

        List<T>[] allFilesReaded = new LinkedList[inputFiles.size()];

        for(int i=0; i < inputFiles.size();i++){

            try{

                File file = new File(inputFiles.get(i));
                BufferedReader reader = new BufferedReader(new FileReader(file));

                String readedString;
                LinkedList<T> readedFile = new LinkedList<>();

                while((readedString = reader.readLine())!=null) {

                    if (readedString.contains(" ") || readedString.equals("")) {
                        showMessage.showDataErrorMessage(readedString);
                    } else if (readedFile.size() > 0 && ((String) readedFile.get(readedFile.size() - 1)).compareTo(readedString) * sortType < 0) {
                        showMessage.showNotSortedMessage(readedString);
                    } else {
                        try {
                            readedFile.add((T) readedString);
                        } catch (ClassCastException e) {
                            showMessage.showDataErrorMessage(readedString);
                        }
                    }
                }
                reader.close();
                if(readedFile.size() != 0) {
                    allFilesReaded[i] = readedFile;
                }

            } catch (OutOfMemoryError e) {
                e.printStackTrace();
                showMessage.showOutOfMemoryMessage();
            }
            catch(FileNotFoundException e){
                showMessage.showFileNotFoundMessage(e.getMessage());
            }
            catch (IOException e){
                showMessage.showReadingErrorMessage(e.getMessage());

            }

        }

       return allFilesReaded;

    }

    public void writeToFile(List<String> result, String outFile) throws IOException{
        File file = new File(outFile);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        for(String element : result){
            writer.write(element + "\n");
        }

        writer.close();
    }
}

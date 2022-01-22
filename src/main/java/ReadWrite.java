import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReadWrite implements ReadWriteInterface {

    public LinkedList<String>[] readAllToString(ArrayList<String> inputFiles, String sortType) {

        LinkedList<String>[] allFilesReaded = new LinkedList[inputFiles.size()];

        int sort;
        if(sortType.equals("-a")){
            sort = -1;
        } else {
            sort = 1;
        }

        for(int i=0; i < inputFiles.size();i++){

            try{

                File file = new File(inputFiles.get(i));
                BufferedReader reader = new BufferedReader(new FileReader(file));

                String readedString;
                LinkedList<String> readedFile = new LinkedList<>();

                while((readedString = reader.readLine())!=null){

                    if(readedString.contains(" ")){
                        showMessage.showDataErrorMessage(readedString);
                    } else {
                        if(readedFile.size()>0 && (readedFile.get(readedFile.size()-1).compareTo(readedString)*sort < 0)){
                            showMessage.showNotSortedMessage(readedString);
                        } else {
                            readedFile.add(readedString);
                        }
                    }
                }
                reader.close();
                allFilesReaded[i] = readedFile;

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
    public LinkedList<Integer>[] readAllToInteger(ArrayList<String> inputFiles, String sortType) {

        LinkedList<Integer>[] allFilesReaded = new LinkedList[inputFiles.size()];

        int sort;
        if(sortType.equals("-a")){
            sort = -1;
        } else {
            sort = 1;
        }

        for(int i=0; i < inputFiles.size();i++){

            try{

                File file = new File(inputFiles.get(i));
                BufferedReader reader = new BufferedReader(new FileReader(file));

                String readedString;
                LinkedList<Integer> readedFile = new LinkedList<>();

                while((readedString = reader.readLine())!=null){

                        try {
                            if(readedFile.size()>0 && (readedFile.get(readedFile.size()-1).compareTo(Integer.parseInt(readedString))*sort < 0)){
                                showMessage.showNotSortedMessage(readedString);
                            } else {
                                readedFile.add(Integer.parseInt(readedString));
                            }
                        }catch(NumberFormatException e){
                            showMessage.showDataErrorMessage(readedString);
                            showMessage.showNotANumberMessage(readedString);
                        }

                }
                reader.close();
                allFilesReaded[i] = readedFile;

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

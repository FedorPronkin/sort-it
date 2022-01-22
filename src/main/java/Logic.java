import java.util.LinkedList;
import java.util.List;

public class Logic implements LogicInterface {


    public List<String> sortStringFiles(List<String>[] readedFiles, int sortType){

        boolean stopIt = false;
        int[] position = new int[readedFiles.length];
        List<String> result = new LinkedList<>();

        while(!stopIt){

            String valueToWrite = "";
            int valuePosition = 0;

            for(int j = 0; j < position.length; j++) {
                if(position[j] < readedFiles[j].size()){
                    valueToWrite = readedFiles[j].get(position[j]);
                    valuePosition = j;
                    break;
                }
            }

                for(int k = 0; k < position.length; k++){

                    if(position[k] < readedFiles[k].size()) {

                        if (valueToWrite.compareTo(readedFiles[k].get(position[k])) * sortType < 0) {
                            valueToWrite = readedFiles[k].get(position[k]);
                            valuePosition = k;

                        }
                    }
                }

                result.add(valueToWrite);

                if(position[valuePosition] < readedFiles[valuePosition].size()) {
                   position[valuePosition]++;
                }

            stopIt = true;

            for(int i = 0; i < position.length; i++){
                if(position[i] != readedFiles[i].size()){
                    stopIt = false;
                    break;
                }
            }
        }
        return result;
    }

    public List<Integer> sortIntegerFiles(List<Integer>[] readedFiles, int sortType) {

         boolean stopIt = false;
         int[] position = new int[readedFiles.length];
         List<Integer> result = new LinkedList<>();

         while (!stopIt) {

             Integer valueToWrite = 0;
             int valuePosition = 0;

             for (int j = 0; j < position.length; j++) {
                 if (position[j] < readedFiles[j].size()) {
                     valueToWrite = readedFiles[j].get(position[j]);
                     valuePosition = j;
                     break;
                 }
             }

             for (int k = 0; k < position.length; k++) {

                 if (position[k] < readedFiles[k].size()) {

                     if (valueToWrite.compareTo(readedFiles[k].get(position[k])) * sortType < 0) {
                         valueToWrite = readedFiles[k].get(position[k]);
                         valuePosition = k;

                     }
                 }
             }

             result.add(valueToWrite);

             if (position[valuePosition] < readedFiles[valuePosition].size()) {
                 position[valuePosition]++;
             }

             stopIt = true;

             for (int i = 0; i < position.length; i++) {
                 if (position[i] != readedFiles[i].size()) {
                     stopIt = false;
                     break;
                 }
             }

         }
         return result;
     }
}
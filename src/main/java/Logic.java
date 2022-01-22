import java.util.LinkedList;
import java.util.List;

public class Logic<T extends Comparable<T>> implements LogicInterface<T> {

    public List<String> sortFiles(List<T>[] readedFiles, int sortType) {

        boolean stopIt = false;
        int[] position = new int[readedFiles.length];
        List<String> result = new LinkedList<>();

        while (!stopIt) {

            T valueToWrite = null;
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

            result.add((String) valueToWrite);

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
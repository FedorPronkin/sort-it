public class ShowMessage implements ShowMessageInterface {

    public void showOutOfDataTypeError(){
        System.out.println("Ошибка! Не указан тип данных во входных файлах! Программа завершает работу!");
    }

    public void showNoOutFileMessage(){
        System.out.println("Ошибка! Отсутствует имя выходного файла! Программа завершает работу!");
    }

    public void showNoInputFileMessage(){
        System.out.println("Ошибка! Отсутствуют входные файлы! Программа завершает работу!");
    }

    public void showOutOfMemoryMessage(){
        System.out.println("Ошибка при чтении файла! Файл слишком большой и будет пропущен!");
    }

    public  void showNoParametersMessage(){
        System.out.println("Ошибка! Отсутствуют обязательные параметры запуска!");
    }

    public  void showFileNotFoundMessage(String error){
        System.out.println("Ошибка при чтении файла: " + error + "!");
    }

    public  void showReadingErrorMessage(String error){
        System.out.println("Ошибка! Ошибка чтения из файла. Данные могут быть потеряны! (" + error + ")");
    }

    public  void showDataErrorMessage(String data){
        System.out.println("Ошибка! Данные (" + data + ")не соответствуют условиям и будут пропущены !");
    }

    public  void showNotSortedMessage(String data){
        System.out.println("Ошибка! Данные (" + data + ") не соответствуют заданной сортировке и будут пропущены!");
    }

    public  void showWriteErrorMessage(String error){
        System.out.println("Ошибка Записи в выходной файл " + (error) + "!");
    }

    public void showWritingSuccessMessage() {
        System.out.println("Запись отсортированного файла успешно завершена!");
    }

    public void showNoFilesMessage(String fileName){
        System.out.println("Входной файл: " + fileName + " не найден!");
    }

    public void showCastErrorMessage(){
        System.out.println("Ошибка преобразования данных! Данные будут пропущены!");
    }

    public void showUnknownParams(String param){
        System.out.println("Введен неизвестный параметр (" + param + ")! Параметр будет проигнорирован!");
    }
}

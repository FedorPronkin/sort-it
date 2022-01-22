public class ShowMessage implements ShowMessageInterface {

    public void showOutOfDataTypeError(){
        System.out.println("Ошибка! Не указан тип данных во входных файлах! Программа завершает работу!");
    }

    public void showNoOutFileMessage(){
        System.out.println("Ошибка! Отсутствует имя выходного файла! Программа завершает работу!");
    }

    public void showNoInputFileMessage(){
        System.out.println("Ошибка! Отсутствуют имена входных файлов! Программа завершает работу!");
    }

    public void showOutOfMemoryMessage(){
        System.out.println("Ошибка при чтении файла! Файл слишком большо и будет пропущен!");
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

    public  void showNotANumberMessage(String data){
        System.out.println("Ошибка! Данные (" + data + ") не соответствуют условиям и будут пропущены (не являются целым числом)!");
    }

    public  void showNotSortedMessage(String data){
        System.out.println("Ошибка! Данные (" + data + ") не соответствуют заданной сортировке и будут пропущены!");
    }

    public  void showWriteErrorMessage(String error){
        System.out.println("Ошибка Записи в выходно  файл " + (error) + "!");
    }

    public void showWritingSuccessMessage() {
        System.out.println("Запись отсортированного файла успешно завершена!");
    }
}

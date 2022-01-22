public interface ShowMessageInterface {

    void showOutOfDataTypeError();
    void showNoOutFileMessage();
    void showNoInputFileMessage();
    void showOutOfMemoryMessage();
    void showNoParametersMessage();
    void showFileNotFoundMessage(String error);
    void showReadingErrorMessage(String error);
    void showDataErrorMessage(String data);
    void showNotSortedMessage(String data);
    void showWriteErrorMessage(String error);
    void showWritingSuccessMessage();
    void showNoFilesMessage(String fileName);
    void showUnknownParams(String param);
}

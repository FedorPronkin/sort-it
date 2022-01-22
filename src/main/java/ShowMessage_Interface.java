public interface ShowMessage_Interface {
    void showOutOfDataTypeError();
    void showNoOutFileMessage();
    void showNoInputFileMessage();
    void showOutOfMemoryMessage();
    void showNoParametersMessage();
    void showFileNotFoundMessage(String error);
    void showReadingErrorMessage(String error);
    void showDataErrorMessage(String data);
    void showNotANumberMessage(String data);
    void showNotSortedMessage(String data);
    void showWriteErrorMessage(String error);
    void showWritingSuccessMessage();
}

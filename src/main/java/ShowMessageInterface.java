public interface ShowMessageInterface {

    void showOutOfDataTypeError();

    void showNoOutFileMessage();

    void showNoInputFileMessage();

    void showNoParametersMessage();

    void showFileNotFoundMessage(String error);

    void showReadingErrorMessage(String error);

    void showDataErrorMessage();

    void showNotSortedMessage(String data, String fileName);

    void showWriteErrorMessage(String error);

    void showWritingSuccessMessage();

    void showNoFilesMessage(String fileName);

    void showUnknownParams(String param);

    void showClosingFilesError(String error);

    void showOutFileIsEmpty();

    void showTooManyDataTypeParams();

    void showTooManySortParams();
}

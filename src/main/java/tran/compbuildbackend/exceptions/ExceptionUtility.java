package tran.compbuildbackend.exceptions;

import tran.compbuildbackend.exceptions.request.GenericRequestException;

public class ExceptionUtility {

    public static void throwMessageException(String exceptionMessage) {
        GenericRequestException exception = new GenericRequestException();
        exception.setMessage(exceptionMessage);
        throw exception;
    }

}

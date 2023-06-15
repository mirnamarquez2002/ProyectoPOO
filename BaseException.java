/*
 * We create an abstract class to manage all exceptions in subclasses
 */

public abstract class BaseException extends Exception{

    private String message;

    public BaseException(String message){
        super(message);
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
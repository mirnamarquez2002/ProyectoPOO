
public class programExceptions{

    //When we receive a number without hexadecimal format
    public static class invalidParseException extends BaseException{

        public invalidParseException(String msg){
            super(msg);
        }
    }

}
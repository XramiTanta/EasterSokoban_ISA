package Exceptions;

public class BoardConstructorException extends Exception{
    private String additionalInfo;

    public BoardConstructorException(String message,String additionalInfo){
        super(message);
        this.additionalInfo = additionalInfo;
    }
    public BoardConstructorException(String additionalInfo){
        this.additionalInfo = additionalInfo;
    }


    public String getAdditionalInfo(){
        return this.additionalInfo;
    }

    @Override
    public String getMessage(){
        return super.getMessage() + " " + "illegal input \n" +
                "-> The Board can not be build \n"
                +"-> " + additionalInfo;
    }


}

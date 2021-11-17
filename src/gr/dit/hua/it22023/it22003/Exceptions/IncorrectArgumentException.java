package gr.dit.hua.it22023.it22003.Exceptions;

public class IncorrectArgumentException extends Exception
{
    @SuppressWarnings("unused")
    public IncorrectArgumentException(String message)
    {
        super(message);
    }
    
    public IncorrectArgumentException()
    {
    }
}

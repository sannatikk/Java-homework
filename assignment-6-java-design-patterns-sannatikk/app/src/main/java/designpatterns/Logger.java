package designpatterns;

public class Logger {

    private Logger (){}

    private static Logger instance;

    public static Logger getInstance(){
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }

    public String log(String message){
        return "Logger: " + message;
    }
    
}

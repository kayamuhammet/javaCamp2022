import javax.xml.crypto.Data;

public class Main {
    public static void main(String[] args) {
//        EmailLogger logger = new EmailLogger();
//        logger.Log("Log Messajı");

//        BaseLogger[] loggers = new BaseLogger[]{new FileLogger(), new EmailLogger(), new DatabaseLogger()};
//        for(BaseLogger logger:loggers){
//            logger.Log("Log Mesajı:");
//        }

        CustomerManager customerManager = new CustomerManager(new FileLogger());
        customerManager.add();
    }
}

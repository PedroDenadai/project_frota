import java.util.HashMap;


public class Logins {

    HashMap<String, String> logins = new HashMap<String, String>();

    public void inserirLogin(String login, String password){
        if(!logins.containsKey(login)){
            logins.put(login, password);
        }
    }


    public Logins() {

    }
}

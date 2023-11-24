import Tools.DBConnetion;
import Tools.LoginPage;

public class Main {
    public static void main(String[] args) {
        DBConnetion conn = new DBConnetion();
        LoginPage loginPage = new LoginPage(conn);
    }
}
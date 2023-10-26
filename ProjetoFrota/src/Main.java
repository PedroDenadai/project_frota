import Tools.LoginPage;

public class Main {
    public static void main(String[] args) {
        Logins baseDeDados = new Logins();

        baseDeDados.inserirLogin("pedrohsemensato459@gmail.com", "99519373");
        LoginPage page = new LoginPage(baseDeDados.logins);
    }
}
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //teste
        Funcionario funcionario = new Funcionario("12345", "João", Funcionario.Departamento.Engenharia);
        System.out.println(funcionario.toString());
        
        Menu menu = new Menu();
        menu.iniciarMenu();
        System.out.println(menu.listaFuncionarios);
    }
}

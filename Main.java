import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //teste
        Funcionario funcionario = new Funcionario("12345", "João", Departamento.Engenharia);
        // System.out.println(funcionario.toString());
        Custo custo = new Custo(100,"impressora", LocalDate.now(), "impressora", funcionario, Departamento.RH);
        System.out.println(custo.toString());

        Menu menu = new Menu();
        menu.listaFuncionarios.AddFuncionario(funcionario);
        menu.listaCustos.AddCusto(custo);
        menu.iniciarMenu();
        if(!menu.sair()){
            System.out.println(menu.listaFuncionarios);
        }
        
    }
}

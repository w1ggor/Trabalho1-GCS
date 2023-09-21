import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    List<Funcionario> listaFuncionarios = new ArrayList<>();


    public void chamaMenu(){
        System.out.println("Olá, fulano");
        System.out.println("Selecione uma das opcoes abaixo:");
        System.out.println("1. Criar usuário");
        System.out.println("2. Registrar um custo");
        System.out.println("3. Pesquisa de custo");
        System.out.println("4. Excluir custo");
        System.out.println("5. Metricas");

        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                criarFuncionario();
                break;
            case 2:
                registrarCusto();
                break;
            case 3:
                pesquisaCusto();
                break;
            case 4: 
                excluirCusto();
                break;
            case 5:
                metricas();
                break;
            default:
                System.out.println("Opcao invalida");
        }
    }

    private void metricas() {
    }

    private void excluirCusto() {
    }

    private void pesquisaCusto() {
    }

    private void registrarCusto() {
    }

    private void criarFuncionario() {
        System.out.println("Digite o nome do funcionário:");
        String nome = sc.nextLine();
        System.out.println("Digite o numero de matricula:");
        String nroMatricula = sc.nextLine();
        System.out.println("Selecione o departamento");
        System.out.println("1. Compras");
        System.out.println("2. Vendas");
        System.out.println("3. Expedicao");
        System.out.println("4. Engenharia");
        System.out.println("5. Producao");
        int selecionaDepartamento = sc.nextInt();

        Funcionario funcionario = null;

        switch (selecionaDepartamento) {
            case 1:
                funcionario = new Funcionario(nroMatricula, nome, Funcionario.Departamento.Compras);
                break;
            case 2:
                funcionario = new Funcionario(nroMatricula, nome, Funcionario.Departamento.Vendas);
                break;
            case 3:
                funcionario = new Funcionario(nroMatricula, nome, Funcionario.Departamento.Expedicao);
                break;
            case 4:
                funcionario = new Funcionario(nroMatricula, nome, Funcionario.Departamento.Engenharia);
                break;
            case 5:
                funcionario = new Funcionario(nroMatricula, nome, Funcionario.Departamento.Producao);
                break;
            default:
                System.out.println("Opcao invalida.");
                break;
        }
        listaFuncionarios.add(funcionario);
    }
}
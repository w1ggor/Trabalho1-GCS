import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    List<Funcionario> listaFuncionarios = new ArrayList<>();
    List<Custo> listaCustos = new ArrayList<>();
    
    public void iniciarMenu(){
        System.out.println("Ola, fulano");
        System.out.println("Selecione uma das opcoes abaixo:");
        System.out.println("1. Criar funcionario");
        System.out.println("2. Registrar um custo");
        System.out.println("3. Pesquisa de custo");
        System.out.println("4. Excluir custo");
        System.out.println("5. Painel de metricas");

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
                gerarPainelMetricas();
                break;
            default:
                System.out.println("Opcao invalida");
        }
        sc.close();
    }

    private void excluirCusto() {
    }

    private void pesquisaCusto() {
        sc.nextLine();
        System.out.println("Digite a descrição do custo:");
        String descricao = sc.nextLine();
        for(Custo c : listaCustos){
            if(c.getDescricao().contains(descricao)){
                System.out.println(c.toString());
                return;
            }
        }
        System.out.println("Custo não encontrado!");
    }

    private void registrarCusto() {
    }

    private void criarFuncionario() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do funcionario:");
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
                funcionario = new Funcionario(nroMatricula, nome, Departamento.Compras);
                break;
            case 2:
                funcionario = new Funcionario(nroMatricula, nome, Departamento.Vendas);
                break;
            case 3:
                funcionario = new Funcionario(nroMatricula, nome, Departamento.Expedicao);
                break;
            case 4:
                funcionario = new Funcionario(nroMatricula, nome, Departamento.Engenharia);
                break;
            case 5:
                funcionario = new Funcionario(nroMatricula, nome, Departamento.Producao);
                break;
            default:
                System.out.println("Opcao invalida.");
                break;
        }
        listaFuncionarios.add(funcionario);
        sc.close();
    }

    private void gerarPainelMetricas() {
        System.out.println("Funcionario ");
        System.out.println("Valor total dos custos do mes atual R$ ");
        System.out.println("Valor total dos custos dos ultimos tres meses por departamento: ");
        System.out.println("Departamento de compras R$ ");
        System.out.println("Departamento de vendas R$ ");
        System.out.println("Departamento de expedicao R$ ");
        System.out.println("Departamento de engenharia R$ ");
        System.out.println("Departamento de producao R$ ");
        System.out.println("Funcionarios com a maior soma de custos registrados:");
        System.out.println("1. ");
        System.out.println("2. ");
        System.out.println("3. ");
    }
}
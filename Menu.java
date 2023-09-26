import java.time.LocalDate;
import java.util.Scanner;
import java.util.EnumSet;

public class Menu {
    Scanner sc = new Scanner(System.in);
    ListaFuncionarios listaFuncionarios = new ListaFuncionarios();
    listaCustos listaCustos = new listaCustos();

    int id = 0;
    public void iniciarMenu(){
        
        do{
            for (Funcionario f : listaFuncionarios.getListaFuncionarios()) {
                System.out.println(listaFuncionarios.toString(f)+ "\n");
               
            }
            System.out.println("Informe o numero de matricula do funcionario que deseja acessar: ");
            id = sc.nextInt();

            if(listaFuncionarios.getFuncionarioByMatricula(id) == null){
                System.out.println("----- Matricula Inválida! Informe uma matrícula correta!-----\n");
                id = 0;
            }               
        }while(id == 0);

        System.out.println("Ola, " + listaFuncionarios.getFuncionarioByMatricula(id).getNome());
        System.out.println("Selecione uma das opcoes abaixo:");
        System.out.println("1. Criar funcionario");
        System.out.println("2. Registrar um custo");
        System.out.println("3. Pesquisa de custo");
        System.out.println("4. Excluir custo");
        System.out.println("5. Painel de métricas");
        System.out.println("6. Editar departamentos");

        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                criarFuncionario();
                break;
            case 2:
                registrarCusto();
                break;
            case 3:
                pesquisaCustoMenu();
                break;
            case 4:
                excluirCusto();
                break;
            case 5:
                gerarPainelMetricas();
                break;
            case 6:
                editarDepartamentos();
                break;
            default:
                System.out.println("Opcao invalida");
        }
        sc.close();
    }

    private void excluirCusto() {
    }

    private void pesquisaCustoMenu() {
        sc.nextLine();
        System.out.println("Digite a descrição do custo:");
        String descricao = sc.nextLine();
        Custo aux = listaCustos.pesquisaCusto(descricao);
        if (aux != null) {
            System.out.println(aux.toString());
        } else {
            System.out.println("Custo não encontrado.");
        }
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
        listaFuncionarios.AddFuncionario(funcionario);
        sc.close();
    }

    private void gerarPainelMetricas() {
        System.out.println("\n---------------\n" + listaFuncionarios.getFuncionarioByMatricula(id).getNome());
        System.out.printf("\nValor total dos custos do mês atual -> R$ %.2f\n", listaCustos.somaCustosMes(LocalDate.now()));
        System.out.println("\nValor total dos custos dos últimos 3 meses por departamento: ");
        System.out.printf("\n   Departamento de RH -> R$ %.2f", listaCustos.somaCustosDepartamento(Departamento.RH));
        System.out.printf("\n   Departamento de compras -> R$ %.2f", listaCustos.somaCustosDepartamento(Departamento.Compras));
        System.out.printf("\n   Departamento de vendas -> R$ %.2f", listaCustos.somaCustosDepartamento(Departamento.Vendas));
        System.out.printf("\n   Departamento de expedicao -> R$ %.2f", listaCustos.somaCustosDepartamento(Departamento.Expedicao));
        System.out.printf("\n   Departamento de engenharia -> R$ %.2f", listaCustos.somaCustosDepartamento(Departamento.Engenharia));
        System.out.printf("\n   Departamento de producao -> R$ %.2f\n", listaCustos.somaCustosDepartamento(Departamento.Producao));
        System.out.println("\nFuncionários com a maior soma de custos registrados:\n");
        System.out.println("1. ");
        System.out.println("2. ");
        System.out.println("3. ");
        System.out.println("---------------");
    }

    private void editarDepartamentos(){
        Scanner sc = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n---------- Editar Departamentos ----------\n");
            System.out.println("1. Remover departamento");
            System.out.println("2. Mostrar departamentos");
            System.out.print("Digite a opção desejada: ");
            opcao = sc.nextInt();
            if (opcao != 1 && opcao != 2) System.out.println("Opção inválida!");
        } while (opcao != 1 && opcao != 2);
        
        switch (opcao) {
            case 1:
                removerDepartamento();
                break;
            case 2:
                mostrarDepartamentos();
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        sc.close();
    }

    private void removerDepartamento(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do departamento que deseja remover: ");
        String nome = sc.nextLine();
        EnumSet<Departamento> departamentos = EnumSet.allOf(Departamento.class);
        if (departamentos.remove(Departamento.valueOf(nome))){
            System.out.println("Departamento removido com sucesso!");
        } else {
            System.out.println("Departamento não existe!");
        }
        sc.close();
    }

    private void mostrarDepartamentos(){
        EnumSet<Departamento> departamentos = EnumSet.allOf(Departamento.class);
        System.out.println("Departamentos: ");
        for (Departamento departamento : departamentos) {
            System.out.println(departamento);
        }
    }
}
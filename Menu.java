import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    List<Funcionario> listaFuncionarios = new ArrayList<>();
    List<Custo> listaCustos = new ArrayList<>();

    public void iniciarMenu() {
        System.out.println("Ola, fulano");
        System.out.println("Selecione uma das opcoes abaixo:");
        System.out.println("1. Criar funcionario");
        System.out.println("2. Registrar um custo");
        System.out.println("3. Pesquisa de custo");
        System.out.println("4. Excluir custo");
        System.out.println("5. Painel de metricas");
        System.out.println("6. Editar custo");

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
            case 6:
                editarCusto();
                break;
            default:
                System.out.println("Opcao invalida");
        }
        sc.close();
    }

    private void editarCusto() {
        Scanner in = new Scanner(System.in);
        int op = 0;
        System.out.println("Informe a descrição do custo que deseja editar: ");
        String descricao = in.nextLine();
        if(listaCustos.size() == 0) {
            System.out.println("Não há custos para alterar!");
        } else {
            System.out.println("eae");
            for (Custo c : listaCustos) {
                if (c.getDescricao().contains(descricao)) {
                    System.out.println("Custo encontrado, selecione oque deseja editar: ");
                    System.out.println("1. Valor");
                    System.out.println("2. Descrição");
                    System.out.println("3. Data");
                    System.out.println("4. Categoria");
                    System.out.println("5. Departamento");
                    System.out.println("6. Editar custo");
                    op = sc.nextInt();

                    switch (op) {
                        case 1:
                            System.out.println("Informe o novo valor: ");
                            double valor = sc.nextDouble();
                            c.setValor(valor);
                            System.out.println("Valor atualizado!");
                            break;
                        case 2:
                            System.out.println("Informe a nova descrição: ");
                            String desc = in.nextLine();
                            c.setDescricao(desc);
                            System.out.println("Descrição atualizada!");
                            break;
                        case 3:
                            System.out.println("Informe a nova data: ");
                            System.out.println("Ano: ");
                            int ano = in.nextInt();
                            System.out.println("Mês: ");
                            int mes = in.nextInt();
                            System.out.println("Dia: ");
                            int dia = in.nextInt();
                            LocalDate data = LocalDate.of(ano, mes, dia);
                            c.setData(data);
                            System.out.println("Data atualizada!");
                            break;
                        case 4:
                            System.out.println("Informe a nova categoria: ");
                            String categoria = in.nextLine();
                            c.setCategoria(categoria);
                            System.out.println("Categoria atualizada!");
                            break;
                        case 5:
                            System.out.println("Informe o novo departamento: ");
                            break;
                        default: System.out.println("Opção inválida!");
                    }

                } else {
                    System.out.println("Custo não encontrado");
                }
            }
        }
    }

    private void excluirCusto() {
    }

    private void pesquisaCusto() {
        sc.nextLine();
        System.out.println("Digite a descrição do custo:");
        String descricao = sc.nextLine();
        for (Custo c : listaCustos) {
            if (c.getDescricao().contains(descricao)) {
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
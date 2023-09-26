import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);

    ListaFuncionarios listaFuncionarios = new ListaFuncionarios();
    ListaCustos listaCustos = new ListaCustos();

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
        } while(id == 0);

        System.out.println("Ola, " + listaFuncionarios.getFuncionarioByMatricula(id).getNome());
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
                pesquisaCustoMenu();
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
        if(listaCustos.getListaCustos().size() == 0) {
            System.out.println("Não há custos para alterar!");
        } else {
            for (Custo c : listaCustos.listaCustos) {
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
                            System.out.println("1. RH");
                            System.out.println("2. Compras");
                            System.out.println("3. Vendas");
                            System.out.println("4. Expedição");
                            System.out.println("5. Engenharia");
                            System.out.println("6. Produção");
                            int dep = in.nextInt();
                            switch(dep) {
                                case 1:
                                    c.setDepartamento(Departamento.RH);
                                    break;
                                case 2:
                                    c.setDepartamento(Departamento.Compras);
                                    break;
                                case 3:
                                    c.setDepartamento(Departamento.Vendas);
                                    break;
                                case 4:
                                    c.setDepartamento(Departamento.Expedicao);
                                    break;
                                case 5: 
                                    c.setDepartamento(Departamento.Engenharia);
                                    break;
                                case 6:
                                    c.setDepartamento(Departamento.Producao);
                                    break;
                                default:
                                    System.out.println("Opção inválida!");
                            }
                            break;
                        default: System.out.println("Opção inválida!");
                    }

                } else {
                    System.out.println("Custo não encontrado");
                }
            }
        }
        in.close();
    }

    private void excluirCusto() {
    }

    private void pesquisaCustoMenu() {
        sc.nextLine();
        System.out.println("Digite a descrição do custo:");
        String descricao = sc.nextLine();

      for (Custo c : listaCustos.listaCustos) {
            if (c.getDescricao().contains(descricao)) {
                System.out.println(c.toString());
                return;
            }
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
}
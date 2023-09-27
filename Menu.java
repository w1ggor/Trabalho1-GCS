import java.time.LocalDate;
import java.util.Scanner;
import java.util.EnumSet;

public class Menu {
    Scanner sc = new Scanner(System.in);
    Utils utils = new Utils();

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
        System.out.println("5. Painel de métricas");
        System.out.println("6. Editar custo");
        System.out.println("7. Editar departamentos");


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
            case 7:
                editarDepartamentos();
                break;
            default:
                System.out.println("Opcão inválida");
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
            for (Custo c : listaCustos.getListaCustos()) {
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

    private void pesquisaCusto() {
        utils.limpaConsole();
        sc = new Scanner(System.in);
        System.out.println("Pesquisar custo por:");
        System.out.println("1. Descrição");
        System.out.println("2. Categoria");
        System.out.println("3. Data");
        System.out.println("4. Departamento");
        System.out.println("-");
        System.out.println("0. Voltar para o menu");

        int por = utils.escolha(sc, 4);
        utils.limpaConsole();

        int pesquisa = -1;

        switch (por) {

            case 1:
            System.out.println("Digite a descrição do custo:");
            System.out.println("(Deixe vazio se quiser voltar)");
            while(pesquisa < 0)
            { 
            String descricao = sc.nextLine();

            if(descricao.length() == 0)
            pesquisaCusto();

            for(Custo c : listaCustos.getListaCustos()){
                if(c.getDescricao().contains(descricao)){
                    System.out.println(c.toString());
                    return;
                }
            }
            utils.limpaLinha();
            
            if(pesquisa != -2)
            System.out.println("Custo não encontrado!");

            pesquisa = -2;  
            }
                break;

            case 2:
            System.out.println("Digite a categoria do custo:");
            System.out.println("(Deixe vazio se quiser voltar)");
            while(pesquisa < 0)
            { 
            String categoria = sc.nextLine();

            if(categoria.length() == 0)
            pesquisaCusto();

            for(Custo c : listaCustos.getListaCustos()){
                if(c.getCategoria().contains(categoria)){
                    System.out.println(c.toString());
                    return;
                }
            }
            utils.limpaLinha();
            
            if(pesquisa != -2)
            System.out.println("Custo não encontrado!");

            pesquisa = -2;  
            }
                break;

            case 3:
            System.out.println("Digite a data do custo (Formato: dd/mm/aaaa)");
            System.out.println("(Deixe vazio se quiser voltar)");
            while(pesquisa < 0)
            { 
            String data = sc.nextLine();

            if(data.length() == 0)
            pesquisaCusto();

            if(!utils.validaData(data)){
                utils.limpaLinha();

                if (pesquisa == -2)
                utils.limpaLinha();

                if(pesquisa != -3)
                System.out.println("Formato inválido!");

                pesquisa = -3;
            }
            else
            {
                for(Custo c : listaCustos.getListaCustos()){
                    if(c.getData().equals(utils.converteData(data))){
                        System.out.println(c.toString());
                        return;
                    }
                }
                utils.limpaLinha();

                if(pesquisa == -3)
                utils.limpaLinha();

                if(pesquisa != -2)
                System.out.println("Custo não encontrado!");

                pesquisa = -2;  
            }
            }
                break;

            case 4:
            System.out.println("Selecione o departamento do custo:");
            for(Departamento c  : Departamento.values())
                System.out.println((c.ordinal() + 1) + ". " + c.name());

            System.out.println("-");
            System.out.println("0. Voltar");
            

            while(pesquisa < 0)
            { 

            int departamento = utils.escolha(sc, 4);

            if(departamento == 0)
            pesquisaCusto();
            
            for(Custo c : listaCustos.getListaCustos()){
                if(c.getDepartamento().ordinal() == (departamento - 1)){
                    System.out.println(c.toString());
                    return;
                }
            }
            utils.limpaLinha();
            
            if(pesquisa != -2)
            System.out.println("Custo não encontrado!");

            pesquisa = -2;  
            }
                break;

            case 0:
            iniciarMenu();
                break;
        }
        System.out.println("1. Pesquisar novamente");
        System.out.println("-");
        System.out.println("0. Voltar para o menu");
        int fim = utils.escolha(sc, 1);
        switch (fim) {
            case 1:
            pesquisaCusto();
                break;
        
            case 0:
            iniciarMenu();
                break;
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
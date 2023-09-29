import java.time.LocalDate;
import java.util.Scanner;
import java.util.EnumSet;

public class Menu {
    Scanner sc = new Scanner(System.in);
    Utils utils = new Utils();

    ListaFuncionarios listaFuncionarios = new ListaFuncionarios();
    ListaCustos listaCustos = new ListaCustos();

    int id = 0;
    boolean sair = false;

    public void iniciarMenu() {
        
        while(true){
            while (id == 0 && !sair) {
                for (Funcionario f : listaFuncionarios.getListaFuncionarios()) {
                    System.out.println(listaFuncionarios.toString(f) + "\n");
                }
                boolean validado = false;
                do {
                    System.out.println("Informe o número de matricula do funcionário que deseja acessar: (Digite Sair para fechar)");
                    var validacao = sc.nextLine();

                    if(validacao.equals("Sair") || validacao.equals("sair") || validacao.equals("SAIR")){
                        sair = true;
                        break;
                    }

                    if (!validacao.matches("\\d+")) {
                        System.out.println("----- A matrícula deve conter apenas números!-----\n");
                        validado = false;
                    } else if (listaFuncionarios.getFuncionarioByMatricula(Integer.parseInt(validacao)) == null) {
                        System.out.println("----- Matrícula Inválida! Informe uma matrícula correta!-----\n");
                        id = 0;
                    } else {
                        id = Integer.parseInt(validacao);
                        validado = true;
                    }
                } while (!validado);
            }
            if(sair){
                break;
            }
            

            utils.limpaConsole();

            System.out.println("Olá, " + listaFuncionarios.getFuncionarioByMatricula(id).getNome());
            System.out.println("Selecione uma das opcoes abaixo:");
            System.out.println("1. Criar funcionário");
            System.out.println("2. Editar departamentos");
            System.out.println("3. Registrar um custo");
            System.out.println("4. Editar custo");
            System.out.println("5. Pesquisa de custo");
            System.out.println("6. Excluir custo");
            System.out.println("7. Painel de métricas");
            System.out.println("8. Fechar programa");
            System.out.println("-");
            System.out.println("0. Trocar usuário");

            int opcao = utils.escolha(sc, 8);

            utils.limpaConsole();

            switch (opcao) {
                case 1:
                    criarFuncionario();
                    break;
                case 2:
                    editarDepartamentos();
                    break;
                case 3:
                    registrarCusto();
                    break;
                case 4:
                    editarCusto();
                    break;
                case 5:
                    pesquisaCusto();
                    break;
                case 6:
                    excluirCusto();
                    break;
                case 7:
                    gerarPainelMetricas();
                    break;
                case 8: 
                    sair = true;
                    break;
                case 0:
                    id = 0;
                    iniciarMenu();
                    break;
                default:
                    System.out.println("Opcão inválida");
            }
        }
        sc.close();
    }

    private void editarCusto() {
        Scanner in = new Scanner(System.in);
        int op = 0;
        System.out.println("\n---------- Editar Custos ----------\n");
        System.out.println("Informe a descrição do custo que deseja editar: (Digite Sair para fechar)");
        String descricao = in.nextLine();

        if(descricao.equalsIgnoreCase("sair")){
            iniciarMenu();
        }

        if (listaCustos.getListaCustos().size() == 0) {
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
                    System.out.println("-");
                    System.out.println("0. Voltar");
                    op = utils.escolha(in, 6);

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
                            switch (dep) {
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
                        case 0:
                            utils.limpaConsole();
                            editarCusto();
                            ;
                    }

                } else {
                    System.out.println("Custo não encontrado");
                }
            }
        }
        op=1;
        while(op==1){
            System.out.println("");
            System.out.println("1. Editar novamente");
            System.out.println("-");
            System.out.println("0. Voltar para o menu");
            int fim = utils.escolha(sc, 1);
            utils.limpaConsole();
            switch (fim) {
                case 1:
                    editarCusto();
                    break;

                case 0:
                    iniciarMenu();
                    break;
            }
        }
    }

    private void excluirCusto() {

        System.out.println("\n---------- Excluir Custo ----------\n");
        listaCustos.excluiCusto();
        boolean continuarExcluindo = true;

        while (continuarExcluindo) {
            System.out.println("\n1. Excluir novamente");
            System.out.println("-");
            System.out.println("0. Voltar para o menu");

            int escolha = utils.escolha(sc, 1);
            utils.limpaConsole();

            switch (escolha) {
                case 1:
                    utils.limpaConsole();
                    continuarExcluindo = true;
                    listaCustos.excluiCusto();
                    break;
                case 0:
                    utils.limpaConsole();
                    continuarExcluindo = false;
                    iniciarMenu();
                    break;
                default:
                    System.out.println(
                            "Opção inválida. Por favor, escolha 1 para excluir novamente ou 0 para voltar ao menu.");
            }
        }
    }

    private void pesquisaCusto() {
        sc = new Scanner(System.in);
        System.out.println("\n---------- Pesquisa de Custos ----------\n");
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
                while (pesquisa < 0) {
                    String descricao = sc.nextLine();

                    if (descricao.length() == 0)
                        pesquisaCusto();

                    for (Custo c : listaCustos.getListaCustos()) {
                        if (c.getDescricao().toLowerCase().contains(descricao.toLowerCase())) {
                            System.out.println("");
                            System.out.println(c.toString());
                            pesquisa = 1;
                        }
                    }
                    if (pesquisa < 0) {
                        utils.limpaLinha();

                        if (pesquisa != -2)
                            System.out.println("Custo não encontrado!");

                        pesquisa = -2;
                    }
                }
                break;

            case 2:
                System.out.println("Digite a categoria do custo:");
                System.out.println("(Deixe vazio se quiser voltar)");
                while (pesquisa < 0) {
                    String categoria = sc.nextLine();

                    if (categoria.length() == 0)
                        pesquisaCusto();

                    for (Custo c : listaCustos.getListaCustos()) {
                        if (c.getCategoria().toLowerCase().contains(categoria.toLowerCase())) {
                            System.out.println("");
                            System.out.println(c.toString());
                            pesquisa = 1;
                        }
                    }
                    if (pesquisa < 0) {
                        utils.limpaLinha();

                        if (pesquisa != -2)
                            System.out.println("Custo não encontrado!");

                        pesquisa = -2;
                    }
                }
                break;

            case 3:
                System.out.println("Digite a data do custo (Formato: dd/mm/aaaa)");
                System.out.println("(Deixe vazio se quiser voltar)");
                while (pesquisa < 0) {
                    String data = sc.nextLine();

                    if (data.length() == 0)
                        pesquisaCusto();

                    if (!utils.validaData(data)) {
                        utils.limpaLinha();

                        if (pesquisa == -2)
                            utils.limpaLinha();

                        if (pesquisa != -3)
                            System.out.println("Formato inválido!");

                        pesquisa = -3;
                    } else {
                        for (Custo c : listaCustos.getListaCustos()) {
                            if (c.getData().equals(utils.converteData(data))) {
                                System.out.println("");
                                System.out.println(c.toString());
                                pesquisa = 1;
                            }
                        }
                        if (pesquisa < 0) {
                            utils.limpaLinha();

                            if (pesquisa == -3)
                                utils.limpaLinha();

                            if (pesquisa != -2)
                                System.out.println("Custo não encontrado!");

                            pesquisa = -2;
                        }
                    }
                }
                break;

            case 4:
                System.out.println("Selecione o departamento do custo:");
                for (Departamento c : Departamento.values())
                    System.out.println((c.ordinal() + 1) + ". " + c.name());

                System.out.println("-");
                System.out.println("0. Voltar");

                while (pesquisa < 0) {

                    int departamento = utils.escolha(sc, 4);

                    if (departamento == 0)
                        pesquisaCusto();

                    for (Custo c : listaCustos.getListaCustos()) {
                        if (c.getDepartamento().ordinal() == (departamento - 1)) {
                            System.out.println("");
                            System.out.println(c.toString());
                            pesquisa = 1;
                        }
                    }
                    if (pesquisa < 0) {
                        utils.limpaLinha();

                        if (pesquisa != -2)
                            System.out.println("Custo não encontrado!");

                        pesquisa = -2;
                    }
                }
                break;

            case 0:
                iniciarMenu();
                break;
        }
        System.out.println("");
        System.out.println("1. Pesquisar novamente");
        System.out.println("-");
        System.out.println("0. Voltar para o menu");
        int fim = utils.escolha(sc, 1);
        utils.limpaConsole();
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
        Scanner in = new Scanner(System.in);
        System.out.println("\n---------- Registrar Custo ----------\n");
    
        System.out.println("Informe o valor do custo:");
        double valor = in.nextDouble();
        in.nextLine(); 
    
        System.out.println("Informe a descrição do custo:");
        String descricao = in.nextLine();
    
        System.out.println("Informe a data do custo (Formato: dd/mm/aaaa):");
        String dataInput = in.nextLine();
    
        if (!utils.validaData(dataInput)) {
            System.out.println("Data inválida! Use o formato dd/mm/aaaa.");
            return;
        }
    
        LocalDate data = utils.converteData(dataInput);
    
        System.out.println("Informe a categoria do custo:");
        String categoria = in.nextLine();
    
        System.out.println("Selecione o departamento do custo:");
        for (Departamento c : Departamento.values()) {
            System.out.println((c.ordinal() + 1) + ". " + c.name());
        }
    
        int departamento = utils.escolha(in, Departamento.values().length) - 1;
    
        Departamento departamentoSelecionado = Departamento.values()[departamento];
    
        Funcionario funcionario = listaFuncionarios.getFuncionarioByMatricula(id);
    
        Custo custo = new Custo(valor, descricao, data, categoria, funcionario, departamentoSelecionado);
        listaCustos.AddCusto(custo);
    
        System.out.println("\nCusto registrado com sucesso!");
    
        System.out.println("");
        System.out.println("1. Registrar outro custo");
        System.out.println("-");
        System.out.println("0. Voltar para o menu");
        int fim = utils.escolha(in, 1);
        utils.limpaConsole();
        switch (fim) {
            case 1:
                registrarCusto();
                break;
            case 0:
                iniciarMenu();
                break;
        }
    }    

    private void criarFuncionario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n---------- Criar Funcionario ----------\n");

        boolean validado = false;
        String nome = "";
        do {
            System.out.println("Digite o nome do funcionario:");
            nome = sc.nextLine();
            if (!nome.matches("[a-zA-Z]+") || nome == "") {
                System.out.println("----- O nome nao pode conter numeros ou caracteres especiais! -----\n");
            } else
                validado = true;
        } while (!validado);

        validado = false;
        String nroMatricula;
        do {
            System.out.println("Digite o numero de matricula:");
            nroMatricula = sc.nextLine();
            if (!nroMatricula.matches("\\d+")) {
                System.out.println("----- A matricula deve conter apenas numeros! -----\n");
            } else
                validado = true;
        } while (!validado);

        int selecionaDepartamento = 999;
        validado = false;
        do {
            System.out.println("Selecione o departamento");
            System.out.println("1. Compras");
            System.out.println("2. Vendas");
            System.out.println("3. Expedicao");
            System.out.println("4. Engenharia");
            System.out.println("5. Producao");
            selecionaDepartamento = sc.nextInt();

            if (selecionaDepartamento < 1 || selecionaDepartamento > 5) {
                System.out.println("----- Opcao invalida! -----\n");
            } else
                validado = true;

        } while (!validado);

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
        }
        listaFuncionarios.AddFuncionario(funcionario);

        System.out.println("\nAdicionado com sucesso \n");
        System.out.println("1. Adicionar outro");
        System.out.println("-");
        System.out.println("0. Voltar para o menu");
        int fim = utils.escolha(sc, 1);
        utils.limpaConsole();
        switch (fim) {
            case 1:
                criarFuncionario();
                break;

            case 0:
                iniciarMenu();
                break;
        }
    }

    private void gerarPainelMetricas() {
        System.out.println("\n---------- Painel de Metricas ----------\n");
        System.out.println("\n---------------\n" + listaFuncionarios.getFuncionarioByMatricula(id).getNome());
        System.out.printf("\nValor total dos custos do mês atual -> R$ %.2f\n",
                listaCustos.somaCustosMes(LocalDate.now()));
        System.out.println("\nValor total dos custos dos últimos 3 meses por departamento: ");
        System.out.printf("\n   Departamento de RH -> R$ %.2f", listaCustos.somaCustosDepartamento(Departamento.RH));
        System.out.printf("\n   Departamento de compras -> R$ %.2f",
                listaCustos.somaCustosDepartamento(Departamento.Compras));
        System.out.printf("\n   Departamento de vendas -> R$ %.2f",
                listaCustos.somaCustosDepartamento(Departamento.Vendas));
        System.out.printf("\n   Departamento de expedicao -> R$ %.2f",
                listaCustos.somaCustosDepartamento(Departamento.Expedicao));
        System.out.printf("\n   Departamento de engenharia -> R$ %.2f",
                listaCustos.somaCustosDepartamento(Departamento.Engenharia));
        System.out.printf("\n   Departamento de producao -> R$ %.2f\n",
                listaCustos.somaCustosDepartamento(Departamento.Producao));
        System.out.println("\nFuncionários com a maior soma de custos registrados:\n");
        listaCustos.funcionariosComMaiorCusto();

        System.out.println("---------------");
        System.out.println("");
        System.out.println("-");
        System.out.println("(Enter) Voltar para o menu");
        sc.nextLine();
        utils.limpaConsole();
        iniciarMenu();
    }

    private void editarDepartamentos() {
        Scanner sc = new Scanner(System.in);
        int opcao;
        System.out.println("\n---------- Editar Departamentos ----------\n");
        System.out.println("Selecione uma opcao:");
        System.out.println("1. Remover departamento");
        System.out.println("2. Mostrar departamentos");
        System.out.println("-");
        System.out.println("0. Voltar para o menu");

        opcao = utils.escolha(sc, 2);

        switch (opcao) {
            case 1:
                removerDepartamento();
                break;
            case 2:
                mostrarDepartamentos();
                break;
            case 0:
                iniciarMenu();
                break;
        }
        System.out.println("");
        System.out.println("1. Editar novamente");
        System.out.println("-");
        System.out.println("0. Voltar para o menu");
        int fim = utils.escolha(sc, 1);
        utils.limpaConsole();
        switch (fim) {
            case 1:
                editarDepartamentos();
                break;

            case 0:
                iniciarMenu();
                break;
        }
    }

    private void removerDepartamento() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n---------- Remover Departamento ----------\n");
        System.out.println("Digite o nome do departamento que deseja remover: ");
        String nome = sc.nextLine();
        EnumSet<Departamento> departamentos = EnumSet.allOf(Departamento.class);
        if (departamentos.remove(Departamento.valueOf(nome))) {
            System.out.println("Departamento removido com sucesso!");
        } else {
            System.out.println("Departamento não existe!");
        }
        sc.close();
    }

    private void mostrarDepartamentos() {
        EnumSet<Departamento> departamentos = EnumSet.allOf(Departamento.class);
        System.out.println("Departamentos: ");
        for (Departamento departamento : departamentos) {
            System.out.println(departamento);
        }
    }

    public boolean sair(){
        return sair;
    }

}
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);

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
                criarUsuario();
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

    private void criarUsuario() {

    }
}

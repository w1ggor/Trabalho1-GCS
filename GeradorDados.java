import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class GeradorDados {
    public void geraFuncionarios(List<Funcionario> lista, int quantidadeFuncionarios, Departamento departamento){
        String matriculaString;
        Integer matricula;
        if (!lista.isEmpty()){
            matriculaString = lista.get(lista.size()-1).getMatricula();
            matricula = (Integer.parseInt(matriculaString) + 1);

        } else {
            matricula = 1;
        }
        for (int i = 0; i < quantidadeFuncionarios; i++){
            matriculaString = matricula.toString();
            Funcionario funcionario = new Funcionario(matriculaString, "Fulano", departamento);
            lista.add(funcionario);
            matricula++;
        }
    }

    public void geraFuncionarios(List<Funcionario> lista, Departamento departamento, String... nomes){
        String matriculaString;
        Integer matricula;
        if (!lista.isEmpty()){
            matriculaString = lista.get(lista.size()-1).getMatricula();
            matricula = (Integer.parseInt(matriculaString) + 1);

        } else {
            matricula = 1;
        }
        for (String nome : nomes) {
            matriculaString = matricula.toString();
            Funcionario funcionario = new Funcionario(matriculaString, nome, departamento);
            lista.add(funcionario);
            matricula++;
        }
    }

    public void geraFuncionarios(List<Funcionario> list, String nomeArquivoCSV){
        String path = "resources/csv/" + nomeArquivoCSV;
        String linha;

        try(BufferedReader leitor = new BufferedReader(new FileReader(path))){
            boolean primeiraLinha = true;
            while ((linha = leitor.readLine()) != null){
                if (primeiraLinha){
                    primeiraLinha = false;
                    continue;
                }
                String[] dados = linha.split(",");
                Funcionario funcionario = new Funcionario(dados[0], dados[1], identificaDepartamento(dados[2]));
                list.add(funcionario);
            }
        } catch (IOException e){
            System.out.println("Arquivo não encontrado ou não foi possível converter linha do .csv para funcionário.");
        }
    }

    public void geraCustos(List<Custo> lista, int quantidadeCustos, int quantidadeDeMesesAtras, Departamento departamento){
        for (int i = 0; i < quantidadeCustos; i++){
            double valor = Math.round(Math.random()*20000.00)/100.00;
            Custo custo = new Custo(valor, "Descricao produto", getDataAtrasada(quantidadeDeMesesAtras), "Categoria", departamento);
            lista.add(custo);
        }
    }

    public void geraCustos(List<Custo> lista, int quantidadeCustos, int quantidadeDeMesesAtras, Departamento departamento, String descricao, String categoria){
        for (int i = 0; i < quantidadeCustos; i++){
            double valor = Math.round(Math.random()*20000.00)/100.00;
            Custo custo = new Custo(valor, descricao, getDataAtrasada(quantidadeDeMesesAtras), categoria, departamento);
            lista.add(custo);
        }
    }

    private LocalDate getDataAtrasada(int meses){
        LocalDate dataAtual = LocalDate.now();
        return dataAtual.minusMonths(meses);
    }

    private Departamento identificaDepartamento(String departamentoString){
        try{
            return Departamento.valueOf(departamentoString);
        } catch (Exception e){
            System.out.println("Não foi identificado nenhum valor correspondente, retornado departamento Expedicao");
            return Departamento.Expedicao;
        }
    }
}

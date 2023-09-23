import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
                String[] dados = linha.split(";");
                Funcionario funcionario = new Funcionario(dados[0], dados[1], parseDepartamento(dados[2]));
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

    public void geraCustos(List<Custo> list, String nomeArquivoCSV){
        String path = "resources/csv/" + nomeArquivoCSV;
        String linha;

        try(BufferedReader leitor = new BufferedReader(new FileReader(path))){
            boolean primeiraLinha = true;
            while ((linha = leitor.readLine()) != null){
                if (primeiraLinha){
                    primeiraLinha = false;
                    continue;
                }
                String[] dados = linha.split(";");
                Custo custo = new Custo(Double.parseDouble(dados[0]), dados[1], parseData(dados[2]), dados[3], parseDepartamento(dados[4]));
                list.add(custo);
            }
        } catch (IOException e){
            System.out.println("Arquivo não encontrado ou não foi possível converter linha do .csv para funcionário.");
        }
    }

    private LocalDate getDataAtrasada(int meses){
        LocalDate dataAtual = LocalDate.now();
        return dataAtual.minusMonths(meses);
    }

    private Departamento parseDepartamento(String departamentoString){
        try{
            return Departamento.valueOf(departamentoString);
        } catch (IllegalArgumentException e){
            throw new RuntimeException("\n ------ Erro! O departamento no .csv não está cadastrado no sistema. ------\n" + e);
        }
    }

    private LocalDate parseData(String dataString){
        try{
            DateTimeFormatter regexData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(dataString, regexData);
        }catch (DateTimeParseException e){
            throw new RuntimeException("\n ------ Erro! A data no .csv não cumpre com os requisitos do sistema. ------\n" + e);
        }
    }
}

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class Custo {
    private double valor;
    private String descricao;
    private LocalDate data;
    private String categoria;
    private Funcionario funcionario;
    private Departamento departamento;
    
    public Custo(double valor, String descricao, LocalDate data, String categoria, Funcionario funcionario, Departamento departamento){
        this.valor = valor;
        this.descricao = descricao;
        this.data = data;
        this.categoria = categoria;
        this.funcionario = funcionario;
        this.departamento = departamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        String dateFormat = "dd/MM/uuuu";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
        .ofPattern(dateFormat)
        .withResolverStyle(ResolverStyle.STRICT);
        
        return "__Custo__ " +
        "\nValor: R$" + valor +
        "\nDescrição: " + descricao +
        "\nData: " +  data.format(dateTimeFormatter)+
        "\nCategoria: " + categoria +
        "\nFuncionário responsável: " + funcionario.getNome() +
        "\nDepartamento: " + departamento.name();
    }
}
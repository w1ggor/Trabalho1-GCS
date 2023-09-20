public class Funcionario {
    private String matricula;
    private String nome;
    private Departamento departamento;

    // Construtor
    public Funcionario(String matricula, String nome, Departamento departamento) {
        this.matricula = matricula;
        this.nome = nome;
        this.departamento = departamento;
    }

    // Getters e Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    // Enum dos departamentos
    public enum Departamento {
        RH,
        Compras,
        Vendas,
        Expedicao,
        Engenharia,
        Producao
    }

    @Override
    public String toString() {
        return "Funcionario{" +
            "matricula='" + matricula + '\'' +
            ", nome='" + nome + '\'' +
            ", departamento=" + departamento +
            '}';
    }
}

import java.time.LocalDate;

public class Custo {
    private double valor;
    private String descricao;
    private LocalDate data;
    private String categoria;
    
    public Custo(double valor, String descricao, LocalDate data, String categoria){
        this.valor = valor;
        this.descricao = descricao;
        this.data = data;
        this.categoria = categoria;
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

    @Override
    public String toString() {
        return "Custo: " +
        "\nValor: R$" + valor +
        "\nDescrição: " + descricao +
        "\nData: " + data +
        "\nCategoria: " + categoria;
    }

    
}

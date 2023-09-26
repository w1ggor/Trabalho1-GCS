import java.util.ArrayList;
import java.time.LocalDate;

public class ListaCustos {
    GeradorDados geraCustos = new GeradorDados();
    ArrayList<Custo> listaCustos = new ArrayList<>();

    public ListaCustos() {
        geraCustos.geraCustos(listaCustos, "custos.csv");
    }

    public void AddCusto(Custo custo) {
        listaCustos.add(custo);
    }

    public ArrayList<Custo> getListaCustos() {
        return this.listaCustos;
    }

    public Custo pesquisaCusto(String descricao) {
        for (Custo c : listaCustos) {
            if (c.getDescricao().contains(descricao)) {
                return c;
            }
        }
        return null;
    }

    public double somaCustosMes(LocalDate data) {
        double somaCusto = 0;
        for (Custo c : listaCustos) {
            if (c.getData().getMonthValue() == data.getMonthValue()) {
                somaCusto += c.getValor();
            }
        }
        return somaCusto;
    }

    public double somaCustosDepartamento(Departamento departamento) {
        double somaCusto = 0;
        LocalDate hoje = LocalDate.now();
    
        for (Custo c : listaCustos) {
            if (c.getDepartamento() == departamento) {
                LocalDate dataCusto = c.getData();
                LocalDate tresMesesAtras = hoje.minusMonths(3);
                    if (dataCusto.isAfter(tresMesesAtras) || dataCusto.isEqual(tresMesesAtras)) {
                        somaCusto += c.getValor();
                    }
            }
        }
        return somaCusto;
    }
}

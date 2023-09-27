import java.util.ArrayList;
import java.time.LocalDate;

public class ListaCustos {
    private static GeradorDados geraCustos = new GeradorDados();
    private static ArrayList<Custo> listaCustos = new ArrayList<>();

    public ListaCustos() {
        if (listaCustos.isEmpty()){
            geraCustos.geraCustos(listaCustos, "custos.csv");
        }
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
    public void funcionariosComMaiorCusto() {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        ArrayList<Double> custos = new ArrayList<>();
        double custo;
        int i = 0;
        for (Custo c : listaCustos) {
            if (i < 3) {
                funcionarios.add(c.getFuncionario());
                custos.add(c.getValor());
                i++;
            } else {
                custo = c.getValor();
                for (int j = 0; j < 3; j++) {
                    if (custo > custos.get(j)) {
                        custos.set(j, custo);
                        funcionarios.set(j, c.getFuncionario());
                        break;
                    }
                }
            }
        }
        System.out.println("Funcionarios com a maior soma de custos registrados:");
        for (int j = 0; j < 3; j++) {
            System.out.println(funcionarios.get(j).getNome() + " - " + custos.get(j));
        }
    }
}

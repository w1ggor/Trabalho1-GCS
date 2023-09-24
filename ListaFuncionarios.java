import java.util.ArrayList;
import java.util.List;
public class ListaFuncionarios {

    GeradorDados geraLista = new GeradorDados();
    List<Funcionario> listaFuncionarios = new ArrayList<>();


    public ListaFuncionarios() {
        geraLista.geraFuncionarios(listaFuncionarios, "funcionarios.csv");       
    }
 
    public void AddFuncionario(Funcionario funcionario){
        listaFuncionarios.add(funcionario);
    }


    public List<Funcionario> getListaFuncionarios() {
        return this.listaFuncionarios;
    }

    public void setListaFuncionarios(List<Funcionario> listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
    }

   
}

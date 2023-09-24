import java.util.ArrayList;
import java.util.List;
public class ListaFuncionarios {

    private GeradorDados geraLista = new GeradorDados();
    private List<Funcionario> listaFuncionarios = new ArrayList<>();


    public ListaFuncionarios() {
        geraLista.geraFuncionarios(listaFuncionarios, "funcionarios.csv");       
    }
 
    public void AddFuncionario(Funcionario funcionario){
        listaFuncionarios.add(funcionario);
    }

    public Funcionario getFuncionarioByMatricula(int matricula){
        for (Funcionario funcionario : listaFuncionarios) {
            if(Integer.parseInt(funcionario.getMatricula()) == matricula)
                return funcionario;
        }
        return null;
    }

    public List<Funcionario> getListaFuncionarios() {
        return this.listaFuncionarios;
    }

     public String toString(Funcionario funcionario){
        return  "Matrícula: " + funcionario.getMatricula() + "; Nome: " + funcionario.getNome() + "; Departamento: " + funcionario.getDepartamento()+";";
     }
   
}

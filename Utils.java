import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.*;

public class Utils {

    public void limpaLinha(int quantidade){
        System.out.print(String.format("\033[%dA",quantidade)); // Move up
        System.out.print("\033[2K"); // Erase line content
    }

    public void limpaLinha(){
        limpaLinha(1);
    }

    public void limpaConsole(){
        System.out.print(String.format("\033[2J"));
    }

    public int escolha(Scanner sc, int max){

        int pesquisa = -1;
        while(pesquisa < 0)
        {
            try 
            {
                int p = sc.nextInt(max + 1);
                pesquisa = p;
            }
            catch (Exception e) 
            {
                limpaLinha();
                if(pesquisa != -2)
                    System.out.println("Opção não encontrada!");
            
                sc = new Scanner(System.in);
                pesquisa = -2;  
            }
        }
        
        sc.nextLine();
        return pesquisa;
    }

    public boolean validaData(String data) {
        String dateFormat = "dd/MM/uuuu";
    
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
        .ofPattern(dateFormat)
        .withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalDate date = LocalDate.parse(data, dateTimeFormatter);
            return true;
        } catch (DateTimeParseException e) {
           return false;
        } 
    }

    public LocalDate converteData(String data){
        String dateFormat = "dd/MM/uuuu";
    
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
        .ofPattern(dateFormat)
        .withResolverStyle(ResolverStyle.STRICT);
         LocalDate date = LocalDate.parse(data, dateTimeFormatter);
        return date;
    }
};
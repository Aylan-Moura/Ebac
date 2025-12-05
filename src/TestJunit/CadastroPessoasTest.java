package TestJunit;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
public class CadastroPessoasTest {
   @Test
   public void testContemSomenteMulheres(){
       List<Pessoa> mulheres = new ArrayList<>();
       mulheres.add(new Pessoa("Maria", "f"));
       mulheres.add(new Pessoa("Antonia", "f"));
       boolean somenteMulheres = mulheres.stream()
               .allMatch(m -> m.getSexo().equalsIgnoreCase("F"));
       assertTrue(somenteMulheres,
               "A lista deve conter somente mulheres");
   }
    @Test
    public void testListaNaoDeveConterHomens() {

        List<Pessoa> mulheres = new ArrayList<>();

        mulheres.add(new Pessoa("Ana", "F"));
        mulheres.add(new Pessoa("Carlos", "M"));  // <- Homem, deve falhar

        boolean somenteMulheres = mulheres.stream()
                .allMatch(m -> m.getSexo().equalsIgnoreCase("F"));

        assertFalse(somenteMulheres,
                "A lista NÃO deve ser validada porque contém um homem.");
    }
}



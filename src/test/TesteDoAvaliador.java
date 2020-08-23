import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.dominio.servico.Avaliador;
import org.junit.Assert;
import org.junit.Test;

public class TesteDoAvaliador {

    @Test
    public void main() {
        //parte 1: cenario
        Usuario joao = new Usuario("João");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");

        Leilao leilao = new Leilao("Playstation 3 novo");

        leilao.propoe(new Lance(joao, 250.0));
        leilao.propoe(new Lance(jose, 400.0));
        leilao.propoe(new Lance(maria, 400.0));

        //parte 2: acao
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        //parte 3: validacao

        double maiorEsperado = 400;
        double menorEsperado = 250;

        System.out.println("Maior lance: ");
        Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);

        System.out.println("Menor lance: ");
        Assert.assertEquals(menorEsperado, leiloeiro.getMaiorLance(), 0.00001);

    }
}

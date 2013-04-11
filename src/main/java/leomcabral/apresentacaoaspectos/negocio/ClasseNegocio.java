package leomcabral.apresentacaoaspectos.negocio;

/**
 *
 * @author leomcabrall
 */
public class ClasseNegocio {

    public void fazAlgo() {
        System.out.println("Dentro do método de negócio");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
    }

}

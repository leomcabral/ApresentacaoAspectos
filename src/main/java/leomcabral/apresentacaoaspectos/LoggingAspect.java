package leomcabral.apresentacaoaspectos;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 *
 * @author leomcabrall
 */
@Aspect
public class LoggingAspect {

    private long st;

    @Pointcut("execution(public * leomcabral.apresentacaoaspectos.negocio.*.*(..))")
    public void logar() {}

    @Around("logar()")
    public Object logar(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println(String.format("Iniciando método de negócio %s",pjp.getSignature()));
        final Object obj = pjp.proceed();
        System.out.println("Depois de executar o método de negócio");
        return obj;
    }

    @Before("logar()")
    public void logarAntes() throws Throwable {
        st = System.currentTimeMillis();

    }

    @After("logar()")
    public void logarDepois() throws Throwable {
        long total = System.currentTimeMillis() - st;

        System.out.println(String.format("Tempo gasto na execução do método: %d ms", total));
    }


}

package anotacao;

import java.lang.annotation.*;

/**
 * @author aylan
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TipoChave {

    String value();
}

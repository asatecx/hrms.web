package af.base.other;

import java.text.MessageFormat;
import java.util.Locale;

import org.springframework.context.support.AbstractMessageSource;

public class OtherMessageSource extends AbstractMessageSource {

    @Override
    protected MessageFormat resolveCode(String code, Locale locale) {
        return new MessageFormat("", locale);
    }

}

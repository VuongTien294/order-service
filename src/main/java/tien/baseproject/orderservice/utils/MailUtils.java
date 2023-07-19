package tien.baseproject.orderservice.utils;

import com.google.common.base.Strings;
import lombok.extern.log4j.Log4j2;
import tien.baseproject.orderservice.constant.MailConstant;
import tien.baseproject.orderservice.dto.kafka.MailMessageDTO;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Log4j2
public class MailUtils {
    public static MailMessageDTO buildMailDTO(Collection<String> receivers, String templateName, Map<String, Object> variables, String customSubject) {
        Optional<MailConstant.Template> template = Arrays.stream(MailConstant.Template.values())
                .filter(tem -> tem.getTemplateName().equals(templateName))
                .findFirst();

        log.info(MessageFormat.format("Get template info state {0}", template.isPresent()));
        String subject = "";
        if (template.isPresent()) {
            subject = Strings.isNullOrEmpty(templateName)
                    ? "Alert Email"
                    : template
                    .get()
                    .getSubject();
        }

        return MailMessageDTO.builder()
                .receivers(receivers)
                .template(templateName)
                .subject(customSubject)
                .variables(variables)
                .build();
    }
}

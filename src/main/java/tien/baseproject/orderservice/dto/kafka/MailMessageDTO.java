package tien.baseproject.orderservice.dto.kafka;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import tien.baseproject.orderservice.constant.MailAttachmentDTO;
import tien.baseproject.orderservice.constant.MailConstant;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MailMessageDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Builder.Default
    @JsonProperty("sender")
    private String sender = MailConstant.SENDER;

    @JsonProperty("receivers")
    private Collection<String> receivers;

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("content")
    private String content;

    @JsonProperty("template")
    private String template;

    @Builder.Default
    private Map<String, Object> variables = new HashMap<>();

    //Cái này để gửi mail có file
    @Builder.Default
    private List<MailAttachmentDTO> mailAttachments = Collections.emptyList();

    @Builder.Default
    @JsonProperty("html")
    private boolean html = true;

    @JsonProperty("locale")
    @Builder.Default
    private Locale locale = LocaleContextHolder.getLocale();

    private String traceId;

    @JsonGetter("variables")
    public Map<String, Object> getVariablesMap() {
        return variables;
    }
}

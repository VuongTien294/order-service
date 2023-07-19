package tien.baseproject.orderservice.constant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MailAttachmentDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private byte[] data;

}

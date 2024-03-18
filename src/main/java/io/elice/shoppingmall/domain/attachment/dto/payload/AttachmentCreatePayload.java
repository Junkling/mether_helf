package io.elice.shoppingmall.domain.attachment.dto.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttachmentCreatePayload {
    private Long itemId;
    private String originPath;
    private String storePath;
}

package io.elice.shoppingmall.domain.attachment.dto.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttachmentResult {
    private Long id;
    private Long itemId;
    private String originPath;
    private String storePath;
}

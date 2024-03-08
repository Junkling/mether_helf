package io.elice.shoppingmall.domain.attachment.service;

import io.elice.shoppingmall.domain.attachment.dto.result.AttachmentResult;
import io.elice.shoppingmall.domain.item.entity.Item;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {
    Long saveAttachment(MultipartFile file, Item item);

    AttachmentResult findAttachment(Long id);

}

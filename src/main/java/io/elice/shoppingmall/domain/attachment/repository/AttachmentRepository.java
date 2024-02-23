package io.elice.shoppingmall.domain.attachment.repository;

import io.elice.shoppingmall.domain.attachment.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
}

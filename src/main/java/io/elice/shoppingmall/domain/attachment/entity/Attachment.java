package io.elice.shoppingmall.domain.attachment.entity;

import io.elice.shoppingmall.common.BassEntity;
import io.elice.shoppingmall.domain.item.entity.Item;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Attachment extends BassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Item item;

    private String originPath;

    private String storePath;


}

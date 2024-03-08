package io.elice.shoppingmall.util.mapsturct;

import org.springframework.data.domain.Page;

import java.util.List;

public interface EntityMapper<D, E>{
    D toDto(final E entity);
    List<D> toDtoList(final List<E> entities);

    default Page<D> toDtoPage(Page<E> entities) {
        return entities.map(this::toDto);
    }
}
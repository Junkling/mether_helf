package io.elice.shoppingmall.util.mapsturct;

import java.util.List;

public interface EntityMapper<D, E>{
    D toDto(final E entity);
    List<D> toDtoList(final List<E> entities);
}
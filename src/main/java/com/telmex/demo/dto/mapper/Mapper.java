package com.telmex.demo.dto.mapper;

import java.util.List;

public interface Mapper<T extends Object,S extends Object> {

    T map(S listaOrigen);
}

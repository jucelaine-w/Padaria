package com.Padaria.Padaria.DTO;

import lombok.Data;

import java.util.List;

@Data
public class CompraDTO {
    private Long usuarioid;
    private List<Long> produtosIds;

}

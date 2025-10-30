package com.Padaria.Padaria.business;

import com.Padaria.Padaria.DTO.CompraDTO;
import com.Padaria.Padaria.infrastructure.entitys.Compra;
import com.Padaria.Padaria.infrastructure.entitys.Padaria;
import com.Padaria.Padaria.infrastructure.entitys.Usuario;
import com.Padaria.Padaria.infrastructure.repository.CompraRepository;
import com.Padaria.Padaria.infrastructure.repository.PadariaRepository;
import com.Padaria.Padaria.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompraService {
    private final UsuarioRepository usuarioReposity;

    private Double calcularValorTotal(List<Padaria> produtos) {
        return produtos.stream()
                .mapToDouble(Padaria::getPreco)
                .sum();

    }
    private final CompraRepository compraRepository;
    private final UsuarioService usuarioService;
    private final PadariaRepository padariaRepository;
    public Compra criarCompraComDTO(CompraDTO dto) {
        Usuario usuario= usuarioReposity.findById(dto.getUsuarioid())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        List<Padaria> produtos = padariaRepository.findAllById(dto.getProdutosIds());

        Compra compra = Compra.builder()
                .usuario(usuario)
                .produtos(produtos)
                .dataCompra(LocalDateTime.now())
                .valorTotal(calcularValorTotal(produtos))
                .build();

        return compraRepository.save(compra);
    }

}


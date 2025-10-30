package com.Padaria.Padaria.business;


import java.util.List;

import com.Padaria.Padaria.infrastructure.entitys.Padaria;
import com.Padaria.Padaria.infrastructure.repository.PadariaRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PadariaService {

    private final PadariaRepository padariaRepository;

    public void salvarPadaria(Padaria padaria) {
        padariaRepository.save(padaria);
    }

    public Padaria buscarPorId(Long id) {
        return padariaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item de padaria não encontrado com ID: " + id));
    }

    public List<Padaria> listarTodos() {
        return padariaRepository.findAll();
    }

    public void atualizarPadaria(Long id, Padaria novaPadaria) {
        Padaria existente = padariaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item de padaria não encontrado com ID: " + id));

        existente.setNome(novaPadaria.getNome());
        existente.setPreco(novaPadaria.getPreco());
        existente.setQuantidade(novaPadaria.getQuantidade());

        padariaRepository.save(existente);
    }

    public void deletarPorId(Long id) {
        padariaRepository.deleteById(id);
    }
}

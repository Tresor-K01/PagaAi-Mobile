package com.example.demo.domain.service;

import com.example.demo.domain.dto.Request.MoradorRequest;
import com.example.demo.domain.dto.Response.MoradorReponse;
import com.example.demo.domain.model.Morador;
import com.example.demo.domain.repository.MoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObrigacoesService {

    @Autowired

    private MoradorRepository moradorRepository;


    public MoradorReponse cadastrarMorador(MoradorRequest request){

        Morador morador = new Morador();

        morador.setUsuario(request.usuario());
        morador.setNumero_do_quarto(request.numero_do_quarto());

        return toResponse(moradorRepository.save(morador));
    }
    public List<MoradorReponse> listarMorador(){
        return moradorRepository.findAll().stream().map(this::toResponse).toList();
    }
    private MoradorReponse toResponse(Morador morador){
        return new MoradorReponse(
                morador.getId(),
                morador.getUsuario(),
                morador.getNumero_do_quarto()
        );
    }

}

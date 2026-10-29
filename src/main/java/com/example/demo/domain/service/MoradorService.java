package com.example.demo.domain.service;

import com.example.demo.domain.dto.Request.MoradorRequest;
import com.example.demo.domain.dto.Response.MoradorReponse;
import com.example.demo.domain.model.Morador;
import com.example.demo.domain.model.Usuario;
import com.example.demo.domain.repository.MoradorRepository;
import com.example.demo.domain.repository.UsuarioRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoradorService {

    @Autowired

    private MoradorRepository moradorRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    public MoradorReponse cadastrarMorador(MoradorRequest request){

        // Busca o usuário no banco usando o ID enviado na requisição
        Usuario usuario= usuarioRepository.findById(request.id()).orElseThrow(()->
                new RuntimeException("Id não Encontrado"));

        Morador morador = new Morador();

        morador.setUsuario(usuario);
        morador.setNumero_do_quarto(request.numero_do_quarto());

        return toResponse(moradorRepository.save(morador));
    }
    public MoradorReponse atualizar(Integer id, MoradorRequest request){

       Morador morador= moradorRepository.findById(id).orElseThrow(()->
                new RuntimeException("Morador não encontrado"));




        morador.setNumero_do_quarto(request.numero_do_quarto());

        return toResponse(moradorRepository.save(morador));
    }
    public List<MoradorReponse> listarMorador(){
        return moradorRepository.findAll().stream().map(this::toResponse).toList();
    }
    public MoradorReponse listarporId(Integer id){

        Morador morador= moradorRepository.findById(id).orElseThrow(()->
                new RuntimeException("Morador não encontrado"));

        return toResponse(morador);
    }
    public void apagar(Integer id){


        Morador morador= moradorRepository.findById(id).orElseThrow(()->
                new RuntimeException("Morador não encontrado"));

        moradorRepository.delete(morador);
    }
    private MoradorReponse toResponse(Morador morador){
        return new MoradorReponse(
                morador.getId(),
                morador.getUsuario(),
                morador.getNumero_do_quarto()
        );
    }

}

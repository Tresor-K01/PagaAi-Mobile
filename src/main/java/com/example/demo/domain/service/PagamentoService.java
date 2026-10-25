package com.example.demo.domain.service;

import com.example.demo.domain.dto.Request.PagamentoRequest;
import com.example.demo.domain.dto.Response.PagamentoResponse;
import com.example.demo.domain.model.Pagamento;
import com.example.demo.domain.model.enums.StatusPagamento;
import com.example.demo.domain.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class PagamentoService{


    @Autowired
    private PagamentoRepository pagamentoRepository;

    private PagamentoResponse CadastrarPagamento(PagamentoRequest request){

        Pagamento pagamento = new Pagamento();
        pagamento.setMorador(request.morador());
        pagamento.setValor(request.valor());
        pagamento.setStatusPagamento(request.statusPagamento());

        return toResponse(pagamentoRepository.save(pagamento));

    }
    private PagamentoResponse toResponse(Pagamento pagamento){
        return new PagamentoResponse(

                pagamento.getId(),
                pagamento.getUsuario(),
                pagamento.getMorador(),
                pagamento.getValor(),
                pagamento.getStatusPagamento(),
                pagamento.getDateDoPagamento()
        );
    }
}

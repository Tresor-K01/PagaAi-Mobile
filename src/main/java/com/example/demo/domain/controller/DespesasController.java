package com.example.demo.domain.controller;

 import com.example.demo.domain.dto.Request.DespesasRequest;
 import com.example.demo.domain.dto.Request.UsuarioRequest;
 import com.example.demo.domain.dto.Response.DespesasResponse;
 import com.example.demo.domain.dto.Response.UsuarioResponse;
 import com.example.demo.domain.repository.DespesaRepository;
 import com.example.demo.domain.repository.UsuarioRepository;
 import com.example.demo.domain.service.DespesasService;
 import com.example.demo.domain.service.UsuarioService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.*;

 import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/despesas")

public class DespesasController {

    @Autowired

    private DespesaRepository despesaRepository;

    @Autowired
    private DespesasService despesasService;

    @PostMapping
    public ResponseEntity<DespesasResponse> cadastrarDespesas(DespesasRequest request){

        return new ResponseEntity<>(despesasService.cadastrarDespesas(request), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<DespesasResponse>> listarDespesas(){
        return new ResponseEntity<>(despesasService.listarDespesas(),HttpStatus.OK);

    }

}

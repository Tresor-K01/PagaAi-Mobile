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
    @PutMapping("/{id}")
    public ResponseEntity<DespesasResponse>atualizarporId(@RequestBody DespesasRequest request, @PathVariable Integer id){
        return new ResponseEntity<>(despesasService.atualizarDespesas(id, request), HttpStatus.ACCEPTED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DespesasResponse>listarPorId(@PathVariable Integer id){
        return new ResponseEntity<>(despesasService.listarPorId(id),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>apagar(@PathVariable Integer id){
        despesasService.apagarDespesas(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

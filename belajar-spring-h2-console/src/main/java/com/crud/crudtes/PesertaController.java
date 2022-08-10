package com.crud.crudtes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.crudtes.db.Peserta;
import com.crud.crudtes.repo.PesertaRepo;

@RestController
@RequestMapping("/api/peserta")
public class PesertaController {
    
    private PesertaRepo repo;

    public PesertaController(PesertaRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    public ResponseEntity<?> getPeserta(){
        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPesertaById(@PathVariable Long id){
        Peserta peserta = repo.findById(id).orElse(null);
        if (peserta == null) {
            return new ResponseEntity<>("Peserta not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(peserta, HttpStatus.OK);
    }
    
    @PutMapping ("/{id}")
    public ResponseEntity<?> updatePeserta(@RequestBody Peserta peserta, @PathVariable Long id){
        peserta.setId(id);
        repo.save(peserta);
        return new ResponseEntity<>(peserta, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postPeserta(@RequestBody Peserta peserta) {
        repo.save(peserta);
        return new ResponseEntity<>(peserta, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePeserta(@PathVariable Long id) {
        repo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

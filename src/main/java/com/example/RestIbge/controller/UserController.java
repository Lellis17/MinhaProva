package com.example.RestIbge.controller;

import com.example.RestIbge.model.UserEntity;
import com.example.RestIbge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/noticias")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/noticias")
    public ResponseEntity<String> obterNoticias() {
        String noticias = userService.obterNoticias();
        return ResponseEntity.ok(noticias);
    }

    @PostMapping("/noticias")
    public ResponseEntity<UserEntity> inserirNoticia(@RequestBody UserEntity noticia) {
        userService.inserirDados(String.valueOf(noticia));
        return new ResponseEntity<>(noticia, HttpStatus.CREATED);
    }

    @GetMapping("/noticias/releases")
    public ResponseEntity<List<UserEntity>> obterRelease() {
        List<UserEntity> releases = userService.obterRelease();
        return ResponseEntity.ok(releases);
    }

    @GetMapping("/noticias/releases/{id}")
    public ResponseEntity<UserEntity> obterNoticiaPorId(@PathVariable String id) {
        UserEntity noticia = userService.obterNoticiasReleases(id);
        if (noticia != null) {
            return ResponseEntity.ok(noticia);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/noticias/{id}")
    public ResponseEntity<UserEntity> atualizarNoticia(@PathVariable String id, @RequestBody UserEntity noticia) {
        UserEntity updatedNoticia = userService.atualizar(id, noticia);
        if (updatedNoticia != null) {
            return ResponseEntity.ok(updatedNoticia);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/noticias/{id}")
    public ResponseEntity<Void> excluirNoticia(@PathVariable String id) {
        userService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    // Métodos adicionais para consultas personalizadas

    @GetMapping("/noticias/buscarPorReleases/{Releases}")
    public ResponseEntity<List<UserEntity>> buscarPorReleases(@PathVariable String Releases) {
        List<UserEntity> noticias = userService.buscarPorReleases(Releases);
        return ResponseEntity.ok(noticias);
    }

    @GetMapping("/noticias/buscarPornoticiasRelease/{noticiasRelease}")
    public ResponseEntity<List<UserEntity>> buscarPornoticiasRelease(@PathVariable String noticiasRelease) {
        List<UserEntity> noticias = userService.buscarPornoticiasRelease(noticiasRelease);
        return ResponseEntity.ok(noticias);
    }

    @GetMapping("/noticias/buscarPortipodeNoticias/{tipodeNoticias}")
    public ResponseEntity<List<UserEntity>> buscarPortipodeNoticias(@PathVariable String tipodeNoticias) {
        List<UserEntity> noticias = userService.buscarPortipodeNoticias(tipodeNoticias);
        return ResponseEntity.ok(noticias);
    }

    @GetMapping("/noticias/buscarrelease/{release}")
    public ResponseEntity<List<UserEntity>> buscarrelease(@PathVariable String release) {
        List<UserEntity> noticias = userService.buscarrelease(release);
        return ResponseEntity.ok(noticias);
    }
}

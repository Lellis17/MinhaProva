package com.example.RestIbge.repository;

import com.example.RestIbge.model.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {
    // Métodos de CRUD já estão disponíveis
    //findAll, findById, save, deleteById

    // Utilizando consultas personalizadas
    List<UserEntity> findBynoticiasRelease(String noticiasRelease);
    List<UserEntity> findBytipodeNoticias(String tipodeNoticias);
    List<UserEntity> findByrelease(String release);
}
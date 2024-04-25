package com.example.RestIbge.service;
import com.example.RestIbge.model.UserEntity;
import com.example.RestIbge.repository.UserRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private UserRepository noticiasRepository;

    public String obterNoticias() {
        String dadosNoticias = "";
        String apiUrl = "http://servicodados.ibge.gov.br/api/v3/noticias/";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            dadosNoticias = responseEntity.getBody();
        } else {
            dadosNoticias = "Falha ao obter dados. Código de status: " + responseEntity.getStatusCode();
        }
        inserirDados(dadosNoticias);
        return dadosNoticias;
    }

    public void inserirDados(String dadosNoticia) {
        try {
            JSONArray jsonArray = new JSONArray(dadosNoticia);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                String noticiasRelease = jsonObj.getString("NoticiasRelease");
                String tipoNoticias = jsonObj.getString("tipoNoticias");
                String release = jsonObj.getString("release");
                UserEntity noticia;
                noticia = new UserEntity();
                noticia.setNoticiasRelease(String.valueOf(noticia));
                noticia.setTipodeNoticias(noticia.getTipodeNoticias());
                noticia.setRelease(noticia.getRelease());
                noticiasRepository.save(noticia);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> obterRelease() {
        return userRepository.findAll();
    }

    public UserEntity obterNoticiasReleases(String id) {
        return userRepository.findById(obterNoticiasReleases(id).getRelease()).orElse(null);
    }

    public UserEntity tipodeNoticias(UserEntity user) {
        return userRepository.save(user);
    }

    public UserEntity atualizar(String id, UserEntity newUser) {
        UserEntity existingUser = userRepository.findById(id).orElse(null);

        if (existingUser != null) {
            existingUser.setNoticiasRelease(newUser.getNoticiasRelease());
            existingUser.setTipodeNoticias(newUser.getTipodeNoticias());
            existingUser.setRelease(newUser.getRelease());
            return userRepository.save(existingUser);
        } else {
            // Se o usuário não existe:
            return null;
            // Podemos também lançar uma exceção:
            // throw new EntityNotFoundException("Usuário com id " + id + " não encontrado");
        }
    }

    public void excluir(String noticias) {
        userRepository.deleteById(noticias);
    }

    // Métodos utilizando consultas personalizadas


    public List<UserEntity> buscarPorReleases(String Releases) {
        return userRepository.findByrelease(Releases);
    }

    public List<UserEntity> buscarPornoticiasRelease(String noticiasRelease) {
        return userRepository.findBynoticiasRelease(noticiasRelease);
    }

    public List<UserEntity> buscarPortipodeNoticias(String tipodeNoticias) {
        return userRepository.findBytipodeNoticias(tipodeNoticias);
    }

    public List<UserEntity> buscarrelease(String release) {
        return userRepository.findByrelease(release);
    }


}
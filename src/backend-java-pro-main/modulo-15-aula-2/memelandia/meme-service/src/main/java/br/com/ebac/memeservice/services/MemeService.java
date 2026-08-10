package br.com.ebac.memeservice.services;

import br.com.ebac.memeservice.entities.Meme;
import br.com.ebac.memeservice.repositories.MemeRepository;
import br.com.ebac.memeservice.clients.UserClient;
import br.com.ebac.memeservice.clients.CategoryClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemeService {

    private static final Logger logger = LoggerFactory.getLogger(MemeService.class);
    private final MemeRepository memeRepository;
    private final UserClient userClient;
    private final CategoryClient categoryClient;

    public MemeService(MemeRepository memeRepository, UserClient userClient, CategoryClient categoryClient) {
        this.memeRepository = memeRepository;
        this.userClient = userClient;
        this.categoryClient = categoryClient;
    }

    public List<Meme> findAll() {
        logger.info("Buscando todos os memes");
        return memeRepository.findAll();
    }

    public Optional<Meme> findById(Long id) {
        logger.info("Buscando meme com id={}", id);
        return memeRepository.findById(id);
    }

    public Meme save(Meme meme) {
        logger.info("Iniciando validação para criar meme do usuário {} na categoria {}", meme.getUsuarioId(), meme.getCategoriaId());
        
        try {
            userClient.getUserById(meme.getUsuarioId());
        } catch (Exception e) {
            logger.error("Usuário id={} não encontrado ou serviço indisponível", meme.getUsuarioId());
            throw new IllegalArgumentException("Usuário inválido ou inexistente.");
        }

        try {
            categoryClient.getCategoryById(meme.getCategoriaId());
        } catch (Exception e) {
            logger.error("Categoria id={} não encontrada ou serviço indisponível", meme.getCategoriaId());
            throw new IllegalArgumentException("Categoria inválida ou inexistente.");
        }

        if(meme.getDataCadastro() == null) {
            meme.setDataCadastro(new java.sql.Date(System.currentTimeMillis()));
        }
        
        logger.info("Validações concluídas, salvando meme {}", meme.getNome());
        return memeRepository.save(meme);
    }

    public Meme getMemeDoDia() {
        logger.info("Sorteando meme do dia");
        return memeRepository.findRandomMeme();
    }
}

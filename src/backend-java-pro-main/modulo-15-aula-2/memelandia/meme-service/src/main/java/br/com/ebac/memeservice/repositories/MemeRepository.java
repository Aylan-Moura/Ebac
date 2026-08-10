package br.com.ebac.memeservice.repositories;

import br.com.ebac.memeservice.entities.Meme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemeRepository extends JpaRepository<Meme, Long> {

    @Query(value = "SELECT * FROM meme ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Meme findRandomMeme();
}

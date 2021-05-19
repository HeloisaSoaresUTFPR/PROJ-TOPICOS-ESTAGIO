package utfpr.edu.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utfpr.edu.br.model.Protocolo;
                                                //COMUNICAÇÃO COM O BANCO - GERENCIAMENTO DO BANCO

@Repository
public interface ProtocoloRepository extends JpaRepository<Protocolo,Long> {
}

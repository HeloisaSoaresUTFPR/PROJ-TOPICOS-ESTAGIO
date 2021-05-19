package utfpr.edu.br.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utfpr.edu.br.model.Protocolo;
import utfpr.edu.br.repository.ProtocoloRepository;

@Service    //regra de negocio
public class ProtocoloService {

    @Autowired  // instancia
    private ProtocoloRepository protocoloRepository;


    // função salvar os dados
    public Protocolo salvar(Protocolo novoProtocolo) {
        Protocolo protocoloSalvo = protocoloRepository.save(novoProtocolo); // autom sql
        return protocoloSalvo;

    }

    public void delete(Long id) {
        protocoloRepository.deleteById(id);
    }

    public Protocolo alterar(Protocolo alterarProtocolo) {
        Protocolo protocoloAlterar = protocoloRepository.save(alterarProtocolo);
        return protocoloAlterar;
    }

}

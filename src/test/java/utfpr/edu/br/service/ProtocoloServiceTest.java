package utfpr.edu.br.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import utfpr.edu.br.model.Protocolo;
import utfpr.edu.br.repository.ProtocoloRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProtocoloServiceTest {

    @Mock //funcionalidades
    private ProtocoloRepository protocoloRepository;

    @InjectMocks //inicia classe
    private ProtocoloService protocoloService;


    @Test
    @DisplayName("Teste o metodo de salvar")
    public void salvarProtocolo(){                  //mocando a chamada do save
        when(protocoloRepository.save(any(Protocolo.class))).thenReturn(protocoloComId());

        Protocolo resultdo = protocoloService.salvar(novoProtocolo()); //chamando o método p ser testado

        assertThat(resultdo.getId()).isEqualTo(1L); //validação
        assertThat(resultdo.getDestinatario()).isEqualTo("Teste");
    }



    private Protocolo novoProtocolo() {
        Protocolo protocolo = new Protocolo();

        protocolo.setId(0L);
        protocolo.setDestinatario("Teste");
        protocolo.setProcesso("Processo");
        protocolo.setEspecificacoes("especificação");
        protocolo.setDataEntrega("10/10/2010");
        protocolo.setNovo(true);
        protocolo.setAndamento(false);
        protocolo.setConcluido(false);
        protocolo.setDefeito(false);

        return protocolo;
    }

    private Protocolo protocoloComId() {
        Protocolo protocolo = novoProtocolo();

        protocolo.setId(1L);

        return protocolo;
    }

}
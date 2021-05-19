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
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProtocoloServiceTest {

    @Mock //funcionalidades
    private ProtocoloRepository protocoloRepository;

    @InjectMocks //inicia classe
    private ProtocoloService protocoloService;


    @Test
    @DisplayName("Teste  metodo de salvar") // aceita qualuqer valor tipo protocolo
    public void salvarProtocolo(){                  //mocando a chamada do save
        when(protocoloRepository.save(any(Protocolo.class))).thenReturn(protocoloComId());

        Protocolo resultdo = protocoloService.salvar(novoProtocolo()); //chamando o método p ser testado

        assertThat(resultdo.getId()).isEqualTo(1L); //validação //  resulta valor que eu coloquei é igual ao valor q eu declarei dentro do equals
        assertThat(resultdo.getDestinatario()).isEqualTo("Teste");
    }

    @Test
    @DisplayName("Teste delete") // anylong aceita qualquer valor que seja long
    public void  deletarProtocolo(){
        doNothing().when(protocoloRepository).deleteById(anyLong()); //donothing retorna nada, função que retorna vazio.

        protocoloService.delete(1L); //chama função p testa

        verify(protocoloRepository,times(1)).deleteById(1L);
    }      // verifica // time representa a quantidades de vezes q foi chamado a função deletebyid

    @Test
    @DisplayName("Teste alterar")
    public void  alterarProtocolo(){
        when(protocoloRepository.save(any(Protocolo.class))).thenReturn(protocoloAlterado());

        Protocolo resultado = protocoloService.alterar(protocoloAlterado());

        assertThat(resultado.getId()).isEqualTo(1L);
        assertThat(resultado.getDestinatario()).isEqualTo("HELOO");
    }

    private Protocolo protocoloAlterado() {
        Protocolo protocolo = new Protocolo();

        protocolo.setId(1L);
        protocolo.setDestinatario("HELOO");
        protocolo.setProcesso("Processo");
        protocolo.setEspecificacoes("especificação");
        protocolo.setDataEntrega("10/10/2010");
        protocolo.setNovo(true);
        protocolo.setAndamento(false);
        protocolo.setConcluido(false);
        protocolo.setDefeito(false);

        return protocolo;
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
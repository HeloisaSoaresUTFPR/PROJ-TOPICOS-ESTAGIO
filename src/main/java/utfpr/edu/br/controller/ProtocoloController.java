package utfpr.edu.br.controller;

import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utfpr.edu.br.model.Protocolo;
import utfpr.edu.br.service.ProtocoloService;

@RestController
@RequestMapping("protocolo")
public class ProtocoloController {

    @Autowired
    private ProtocoloService protocoloService;

 // recebe os dados da api              //METODO SALVAR

    @PostMapping("/salvar") //caminho api
    public ResponseEntity salvar(@RequestBody Protocolo protocolo) {
        try{
            Protocolo protocoloSalvo = protocoloService.salvar(protocolo);
            return ResponseEntity.ok(protocoloSalvo);
        }catch(Exception exception) {
            return ResponseEntity.badRequest().body("erro");
        }
    }

                        //MÉTODO DELETE


    @DeleteMapping("/delete/{id}") //
    public ResponseEntity delete(@PathVariable("id") Long id){
        try{
            protocoloService.delete(id);
            return ResponseEntity.ok(true);
        }catch(Exception exception) {
            return ResponseEntity.badRequest().body("erro");
        }

    }

                    //// MÉTODO ALTERAR


    @PutMapping("/alterar")
    public ResponseEntity alterar(@RequestBody Protocolo alterProtocolo) {

        try{
            String msg = validacao(alterProtocolo);
            if (msg.isEmpty()){
                Protocolo protocoloAlterado = protocoloService.alterar(alterProtocolo);
                return ResponseEntity.ok(protocoloAlterado);
            }
            return ResponseEntity.badRequest().body(msg);

        }catch(Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String validacao (Protocolo alterProtocolo){
        String msg = "";
        if (alterProtocolo.getId() == null || alterProtocolo.getId() < 1) {
            msg += "O campo id não deve ser nulo ou menor que um /n";
        }
        return msg;

    }

}

package utfpr.edu.br.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // onde fica configurada as apis
@RequestMapping("ping")  //mapear as apis/ sem isso n consegue identificar qual api é p chamar
public class Ping {

    @GetMapping("/teste")  // mapeamento rota de apis
    public ResponseEntity teste(){
        return ResponseEntity.ok("Teste");
    }
}

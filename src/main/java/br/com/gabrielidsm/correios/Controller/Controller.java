package br.com.gabrielidsm.correios.Controller;

import br.com.gabrielidsm.correios.Error.ResourceNotFoundException;
import br.com.gabrielidsm.correios.Model.Request;
import br.com.gabrielidsm.correios.Model.Response;
import br.com.gabrielidsm.correios.Util.CalculaFrete;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("correios")
public class Controller {
    
    @PostMapping(path = "frete")
    public ResponseEntity<?> Frete (@RequestBody Request request){
        Response response = CalculaFrete.calculaFrete(request);
        if(response == null) throw new ResourceNotFoundException("Invalid Request");
        return new ResponseEntity<>(response , HttpStatus.OK);
    }
    
}
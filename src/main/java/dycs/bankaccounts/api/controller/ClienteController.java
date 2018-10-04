package dycs.bankaccounts.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import dycs.bankaccounts.application.assembler.ProyectoCreateAssembler;
import dycs.bankaccounts.application.dto.ProyectoCreateDto;
import dycs.bankaccounts.domain.entity.Proyecto;
import dycs.bankaccounts.domain.repository.ProyectoRepository;
import dycs.common.application.ApiResponseHandler;
import dycs.common.application.UnitOfWork;

@RestController
@RequestMapping("v1/cliente/{usuarioId}/proyect")
public class ClienteController {
	@Autowired
	UnitOfWork unitOfWork;
	
	@Autowired
	ProyectoRepository prooyectoRepository;
	
	
	@Autowired
	ProyectoCreateAssembler proyectoCreateAssembler;
	
	@Autowired
	ApiResponseHandler apiResponseHandler;
	
	@Transactional(rollbackFor=Exception.class, isolation = Isolation.READ_COMMITTED)
	@RequestMapping(
	    method = RequestMethod.POST,
	    path = "",
	    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
	    produces = MediaType.APPLICATION_JSON_UTF8_VALUE
	)
	public ResponseEntity<Object> create(@PathVariable("clienteId") long clienteId, @RequestBody ProyectoCreateDto proyectoCreateDto) throws Exception {
        try {
        	proyectoCreateDto.setCliente_id(clienteId);
        	//accountCreateValidation.validate(bankAccountCreateDto);
            Proyecto proyecto = proyectoCreateAssembler.toEntity(proyectoCreateDto);            
            prooyectoRepository.create(proyecto);            
            ProyectoCreateDto proyectoCreateDto2 = proyectoCreateAssembler.toDto(proyecto);            
            return new ResponseEntity<Object>(proyectoCreateDto2, HttpStatus.CREATED);
        } catch(IllegalArgumentException ex) {
        	ex.printStackTrace();
        	return new ResponseEntity<Object>(apiResponseHandler.getApplicationError(ex.getMessage()), HttpStatus.BAD_REQUEST);
        } catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Object>(apiResponseHandler.getApplicationException(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }	
	
}


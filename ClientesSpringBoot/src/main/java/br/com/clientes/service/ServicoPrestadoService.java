package br.com.clientes.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import br.com.clientes.data.model.Cliente;
import br.com.clientes.data.model.ServicoPrestado;
import br.com.clientes.repository.ServicoPrestadoRepository;
import br.com.clientes.representation.ServicoPrestadoRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicoPrestadoService {
	
	
	//obligatory constructor arguments
	private final ServicoPrestadoRepository repository;
	private final ClienteService clienteService;
	

	public ServicoPrestado salvar(ServicoPrestadoRequest servicoPrestadoRequest) throws Exception{
		
		Cliente cliente;
		Integer id = null;
		Integer idCliente;
		BigDecimal valor;
		LocalDate data;
		ServicoPrestado ret = new ServicoPrestado();

		try {
			if(servicoPrestadoRequest.getId()!=null) {
				id = Integer.valueOf(servicoPrestadoRequest.getId());
			}
			idCliente = Integer.valueOf(servicoPrestadoRequest.getIdCliente());
			cliente = clienteService.localizarPorId(idCliente);
			servicoPrestadoRequest.setValor(servicoPrestadoRequest.getValor().replace(",", "."));
			valor = new BigDecimal(servicoPrestadoRequest.getValor());
			data = LocalDate.parse(servicoPrestadoRequest.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			ret.setId(id);
			ret.setCliente(cliente);
			ret.setDescricao(servicoPrestadoRequest.getDescricao());
			ret.setValor(valor);
			ret.setData(data);
			
			ret = repository.save(ret);
		}catch(Exception ex) {
			throw new Exception(ex.getMessage());
		}
		return ret;
	}

}

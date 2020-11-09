package br.com.clientes.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.clientes.data.model.Cliente;
import br.com.clientes.data.model.ServicoPrestado;
import br.com.clientes.repository.ServicoPrestadoPesquisaRepository;
import br.com.clientes.repository.ServicoPrestadoRepository;
import br.com.clientes.representation.ServicoPrestadoPesquisa;
import br.com.clientes.representation.ServicoPrestadoRequest;
import br.com.clientes.representation.ServicoPrestadoResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicoPrestadoService {
	
	
	//obligatory constructor arguments
	private final ServicoPrestadoRepository repository;
	private final ClienteService clienteService;
	private final ServicoPrestadoPesquisaRepository pesquisaRepository;
	

	public ServicoPrestadoResponse salvar(ServicoPrestadoRequest servicoPrestadoRequest) throws Exception{
		
		Cliente cliente;
		Integer id = null;
		Integer idCliente;
		BigDecimal valor;
		LocalDate data;
		ServicoPrestadoResponse ret = new ServicoPrestadoResponse();
		ServicoPrestado servicoPrestado = new ServicoPrestado();

		try {
			if(servicoPrestadoRequest.getId()!=null) {
				id = Integer.valueOf(servicoPrestadoRequest.getId());
			}
			idCliente = Integer.valueOf(servicoPrestadoRequest.getIdCliente());
			cliente = clienteService.localizarPorId(idCliente);
			servicoPrestadoRequest.setValor(servicoPrestadoRequest.getValor().replace(".", "").replace(",", "."));
			valor = new BigDecimal(servicoPrestadoRequest.getValor());
			data = LocalDate.parse(servicoPrestadoRequest.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			servicoPrestado.setId(id);
			servicoPrestado.setCliente(cliente);
			servicoPrestado.setDescricao(servicoPrestadoRequest.getDescricao());
			servicoPrestado.setValor(valor);
			servicoPrestado.setData(data);
			
			servicoPrestado = repository.save(servicoPrestado);

			//return object
			ret.setId(servicoPrestado.getId().toString());
			ret.setIdCliente(servicoPrestado.getCliente().getId().toString());
			ret.setDescricao(servicoPrestado.getDescricao());
			ret.setValor(servicoPrestado.getValor().toString());
			ret.setData(servicoPrestado.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			
			
		}catch(Exception ex) {
			throw new Exception(ex.getMessage());
		}
		return ret;
	}

	
	public List<ServicoPrestadoPesquisa> pesquisar(String nome, Integer mes){
		List<ServicoPrestadoPesquisa> ret = new ArrayList<>();
		ret = pesquisaRepository.pesquisar(nome, mes);
		return ret;
	}

}

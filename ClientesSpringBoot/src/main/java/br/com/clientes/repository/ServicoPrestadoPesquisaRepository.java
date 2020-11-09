package br.com.clientes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.clientes.representation.ServicoPrestadoPesquisa;

public interface ServicoPrestadoPesquisaRepository extends JpaRepository<ServicoPrestadoPesquisa, Integer> {

	@Query(value = "select s.id, s.id_cliente, s.descricao, s.valor, s.data from\n"
			+ "servicos s inner join clientes c on s.id_cliente = c.id\n"
			+ "where lower(c.nome) like lower(:nome) and month(s.data) = :mes", nativeQuery = true)
	public List<ServicoPrestadoPesquisa> pesquisar(
				@Param("nome") String nome,
				@Param("mes") Integer mes
			);

	
}

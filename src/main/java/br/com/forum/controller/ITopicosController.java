package br.com.forum.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.forum.controller.dto.DetalhesDoTopicoDto;
import br.com.forum.controller.dto.TopicoDto;
import br.com.forum.controller.form.TopicoForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Topicos", description = "Topicos API")
public interface ITopicosController {

	@Operation(summary = "Retorna a lista de registros paginado.", description = "O filtro padrão é usado", security = { @SecurityRequirement(name = "bearer-key") })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Registros listados com sucesso"),
			@ApiResponse(responseCode = "400", description = "Erro na obtenção dos dados ou filtro"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor")})
	Page<TopicoDto> list(
			@Parameter(description="Pesquisar pelo nome do curso.") String nomeCurso,
			@Parameter(description="Usar os campos e documentação do Pageable.") Pageable pageable);
	
	Page<TopicoDto> list(String nomeCurso, int page, int size, String sort, String direction);
	
	@Operation(summary = "Obter um registro pelo id.", description = "Retorna um registro.", security = { @SecurityRequirement(name = "bearer-key") })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Registro carregado com sucesso."),
			@ApiResponse(responseCode = "404", description = "Registro não encontrado."),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor") })
	ResponseEntity<DetalhesDoTopicoDto> findById(@Parameter(description = "O id do registro a ser obtido. Não pode ser vazio.", required = true) Long id);
	
	@Operation(summary = "Adiciona um novo registro.", description = "Será gravado no banco de dados um novo registro.", security = { @SecurityRequirement(name = "bearer-key") })
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Registro criado com sucesso"),
			@ApiResponse(responseCode = "404", description = "Não foi possível cadastrar o registro."),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor") })
	ResponseEntity<TopicoDto> save(@Valid @Parameter(description = "Registro a ser adicionado. Não pode ser nulo ou vazio.", required = true) TopicoForm form, UriComponentsBuilder uriBuilder);
	
	@Operation(summary = "Atualizar um registro", description = "Atualiza um registro existente.", security = { @SecurityRequirement(name = "bearer-key") })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"),
			@ApiResponse(responseCode = "404", description = "Registro não encontrado."),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor") })
	ResponseEntity<TopicoDto> update(
			@Parameter(description = "Id do registro a ser atualizado. Não pode ser vazio.", required = true) Long id,
			@Parameter(description = "O registro a ser atualizado.", required = true) @Valid TopicoForm form);
	
	@Operation(summary = "Deleta um registro.", description = "Remove o registro da base de dados.", security = { @SecurityRequirement(name = "bearer-key") })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Registro deletado com sucesso"),
			@ApiResponse(responseCode = "404", description = "Registro não encontrado."),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor") })
	ResponseEntity<?> delete(@Parameter(description = "Id do registro a ser deletado. Não pode ser vazio.", required = true) Long id);

}

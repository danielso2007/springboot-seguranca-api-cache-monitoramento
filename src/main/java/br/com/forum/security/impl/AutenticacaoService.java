package br.com.forum.security.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.forum.entity.Perfil;
import br.com.forum.entity.Usuario;
import br.com.forum.repository.UsuarioRepository;
import br.com.forum.security.IAutenticacaoService;

@Service
public class AutenticacaoService implements IAutenticacaoService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findByEmail(username);
		if (usuario.isPresent()) {
			usuario.get();
			UserBuilder builder = null;
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.password(usuario.get().getSenha());
			List<String> roles = usuario.get().getPerfis().stream().map(Perfil::getRole).collect(Collectors.toList());
			String[] rolesArray = new String[roles.size()];
			builder.roles(roles.toArray(rolesArray));
			return builder.build();
		}
		throw new UsernameNotFoundException("User not found.");
	}

}

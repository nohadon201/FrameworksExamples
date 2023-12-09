package ProjecteBolincheYBochinche.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProvaSpring2.Repositoris.JuegoRepository;

@Service
public class PartidaService {
	@Autowired
	JuegoRepository repository;
}

package ProjecteBolincheYBochinche.Repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ProjecteBolincheYBochinche.Model.Monstre;

public interface MonstreRepository extends JpaRepository<Monstre,Integer> {
	
	
	
}

package pruebascrudrepo;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.softnar.app.model.Noticia;
import com.softnar.app.repository.NoticiasRepository;

public class AppUpdate {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository",NoticiasRepository.class);
		
		//OPeracion CRUD - Update [metodo sabve del repository]
		
		//1.Primero buscamos la entidad que vamos a modificar (findById)
		 Optional<Noticia> optional = repo.findById(1);
	    
		 //2. Modificamos la entuidad y la guardamos
		 if (optional.isPresent()) {
			 Noticia noticia = optional.get();
			 noticia.setEstatus("Inactiva");
			 repo.save(noticia);
		 }

	}

}

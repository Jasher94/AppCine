package pruebasjpa;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.softnar.app.model.Noticia;
import com.softnar.app.repository.NoticiasRepository;

public class AppRead {
	

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		//Operacion CRUD - Read [metodo findById del repositorio]
		Optional<Noticia> noticia =  repo.findById(1);
		System.out.println(noticia);
		System.out.println(noticia.get());
		
		context.close();

	}

}

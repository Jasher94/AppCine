package pruebasjparepo;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.softnar.app.model.Noticia;
import com.softnar.app.repository.NoticiasRepository;

public class AppFindAll {

	public static void main(String [] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository",NoticiasRepository.class);
		//Obtener todas las entidades [metodo findAll]
		List<Noticia> lista = repo.findAll();
		for(Noticia n : lista)
			System.out.println(n);
		
		context.close();
	}
}

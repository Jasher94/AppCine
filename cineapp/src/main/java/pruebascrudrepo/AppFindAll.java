package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.softnar.app.model.Noticia;
import com.softnar.app.repository.NoticiasRepository;

public class AppFindAll {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository",NoticiasRepository.class);
		
		//Recuperar todos los registros [metodo FindAll del repositorio]
		
		Iterable<Noticia> it = repo.findAll();
		
		for (Noticia n:it) {
			System.out.println(n);
		}
		
		context.close();

	}

}

package pruebascrudrepo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.softnar.app.model.Noticia;
import com.softnar.app.repository.NoticiasRepository;

public class AppFindAllById {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository",NoticiasRepository.class);
		
		//Recuperar cvarios registros por ID [metodo findAllById del repositorio]
		List<Integer> ids = new LinkedList<Integer>();
		ids.add(2);
		ids.add(5);
		ids.add(8);
		
		Iterable<Noticia> it= repo.findAllById(ids);
		for(Noticia n:it) {
			System.out.println(n);
		}
		
		context.close();

	}

}

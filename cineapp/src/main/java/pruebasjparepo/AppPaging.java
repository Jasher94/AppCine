package pruebasjparepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.softnar.app.model.Noticia;
import com.softnar.app.repository.NoticiasRepository;

public class AppPaging {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository",NoticiasRepository.class);
		
		//Obtener todas las entidades por paginacion
		//Page<Noticia>page = repo.findAll(PageRequest.of(0, 10));
		
		//Obtener todas las entidades por paginacion
		Page<Noticia>page = repo.findAll(PageRequest.of(0, 10, Sort.by("titulo").ascending()));
				
				
		for(Noticia n: page) {
			System.out.println(n);
		}
		
		context.close();

	}

}

package pruebasjpa;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.softnar.app.model.Noticia;
import com.softnar.app.repository.NoticiasRepository;

public class AppCreate {
	

	public static void main(String[] args) {
		
		Noticia noticia = new Noticia();
		noticia.setTitulo("Proximo Estreno: Juego Macabro 8: ");
		noticia.setDetalle("El Mes de Septiembre se estrena la nueva entrega de Saw 8");
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		repo.save(noticia);
		context.close();

	}

}

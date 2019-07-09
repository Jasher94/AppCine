package pruebasquery;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.softnar.app.model.Noticia;
import com.softnar.app.repository.NoticiasRepository;

public class AppKeyWordOr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		// Ejemplo Keyword findBy

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		List<Noticia> lista = null;
		try {
			lista = repo.findByEstatusOrFecha("Activa", format.parse("2017-09-08"));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		for (Noticia n : lista) {
			System.out.println(n);
		}

		context.close();

	}

}

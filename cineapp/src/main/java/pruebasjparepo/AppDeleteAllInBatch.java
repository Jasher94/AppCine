package pruebasjparepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.softnar.app.repository.NoticiasRepository;

public class AppDeleteAllInBatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository",NoticiasRepository.class);
		
		/* Metodo deleteAllInBatch de la interfazz JpaRepository -->(es mas eficiente) 
		 * delete from Noticias 
		 * 
		 * 
		 * Metodo deleteAll de la interfaz CrudRepository -> (no muy eficiente)
		 * 
		 * delete from Noticias  where id=?
		 * delete from Noticias  where id=?
		 * delete from Noticias  where id=?*/
		
		repo.deleteAllInBatch();
		
		context.close();
				
	}

}

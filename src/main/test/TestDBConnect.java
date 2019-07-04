import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import seunghwan.won.config.ApplicationConfig;
import seunghwan.won.dao.CategoryDao;

public class TestDBConnect {
    @Test
    public void name() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        CategoryDao dao = ac.getBean(CategoryDao.class);
        System.out.println(dao.categoryList());
    }
}

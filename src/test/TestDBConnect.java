import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import seunghwan.won.config.ApplicationConfig;
import seunghwan.won.dao.CategoryDao;
import seunghwan.won.dto.Category;

import static org.junit.Assert.assertEquals;

public class TestDBConnect {
    ApplicationContext ac;
    CategoryDao dao;

    @Before
    public void setUp() throws Exception {
        ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        dao = ac.getBean(CategoryDao.class);
    }

    @Test
    public void name() {
        System.out.println(dao.selectAll());
    }

    @Test
    public void insert() {
        Category category = new Category();
        category.setName("testCategory");
        assertEquals(12, dao.insertCategory(category));
        System.out.println(dao.selectAll());
    }

    @Test
    public void select() {
        System.out.println(dao.selectCategoryById(12));
    }

    @Test
    public void update() {
        Category category = new Category();
        category.setId(12);
        category.setName("categoryTest");
        dao.updateCategory(category);
        System.out.println(dao.selectAll());
    }

    @Test
    public void delete() {
        dao.deleteCategoryById(12);
        System.out.println(dao.selectAll());
    }
}

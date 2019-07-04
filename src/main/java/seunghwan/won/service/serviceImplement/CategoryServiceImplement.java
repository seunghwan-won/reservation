package seunghwan.won.service.serviceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seunghwan.won.dao.CategoryDao;
import seunghwan.won.dao.ProductDao;
import seunghwan.won.dto.Category;
import seunghwan.won.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImplement implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Category> getCategoryList() {
        List<Category> categories = categoryDao.selectAll();
        for (Category category : categories) {
            int count = productDao.countByCategoryId(category.getId());
            category.setCount(count);
        }
        return categories;
    }
}

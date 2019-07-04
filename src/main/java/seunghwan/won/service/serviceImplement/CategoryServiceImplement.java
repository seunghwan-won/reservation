package seunghwan.won.service.serviceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seunghwan.won.dao.CategoryDao;
import seunghwan.won.dto.Category;
import seunghwan.won.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImplement implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getCategoryList() {
        return categoryDao.selectAll();
    }
}

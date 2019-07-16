package seunghwan.won.service.serviceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seunghwan.won.dao.CategoryDao;
import seunghwan.won.dto.CategoryJoinProduct;
import seunghwan.won.service.CategoryService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImplement implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    @Transactional
    public Map<String, Object> getCategoryList() {
        Map<String, Object> result = new HashMap<>();
        List<CategoryJoinProduct> categories = categoryDao.selectAll();
        for (CategoryJoinProduct categoryJoinProduct : categories) {
            int count = categoryDao.countByCategoryId(categoryJoinProduct.getId());
            categoryJoinProduct.setCount(count);
        }
        result.put("items", categories);
        return result;
    }
}

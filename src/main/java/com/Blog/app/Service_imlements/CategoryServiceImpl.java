package com.Blog.app.Service_imlements;

import com.Blog.app.Entities.Category;
import com.Blog.app.Entities.User;
import com.Blog.app.Exceptions.ResourceNotFoundException;
import com.Blog.app.Payloads.CategoryDTO;
import com.Blog.app.Payloads.UserDTO;
import com.Blog.app.Repositories.CategoryRepo;
import com.Blog.app.Service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

@Autowired
private CategoryRepo categoryRepo;
@Autowired
private ModelMapper modelMapper;
ModelMapper mapper;

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {


        Category user = dtoToUser(categoryDTO);

        Category savedUser = categoryRepo.save(user);
        System.out.println(savedUser);
        return UserToDto(savedUser);


    }

    private Category dtoToUser(CategoryDTO categoryDTO) {
        Category category = new Category();

        category.setCategoryTitle(categoryDTO.getCategoryTitle());
        category.setCategoryId(categoryDTO.getCategoryId());
        category.setDescription(categoryDTO.getDescriptions());
        return category;
    }


    private CategoryDTO  UserToDto(Category category){
        CategoryDTO categoryDTO=new CategoryDTO();
        category.setCategoryId(categoryDTO.getCategoryId());
        category.setCategoryTitle(categoryDTO.getCategoryTitle());
        category.setDescription(categoryDTO.getDescriptions());
        return categoryDTO;
    }


    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer CategoryId) {
        Category cate=categoryRepo.findById(CategoryId).orElseThrow(()-> new ResourceNotFoundException("Category","Category Id",CategoryId));

cate.setCategoryTitle(categoryDTO.getCategoryTitle());
cate.setDescription(categoryDTO.getDescriptions());

Category updateCategory=categoryRepo.save(cate);

return this.modelMapper.map(updateCategory,CategoryDTO.class);
    }

    @Override
    public void delete(Integer CategoryId) {

        Category cate=categoryRepo.findById(CategoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category Id",CategoryId));

        categoryRepo.delete(cate);
    }

    @Override
    public CategoryDTO getCategory(Integer categoryId) {

        Category cate=categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category Id",categoryId));

    return this.modelMapper.map(cate,CategoryDTO.class);
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        List<Category> cate=categoryRepo.findAll();
        List<CategoryDTO> catee=cate.stream().map((cat)->modelMapper.map(cate,CategoryDTO.class)).collect(Collectors.toList());

        return catee;
    }
}

package com.Blog.app.Controllers;

import com.Blog.app.Payloads.CategoryDTO;
import com.Blog.app.Service.CategoryService;
import com.Blog.app.Service_imlements.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //Create
    @PostMapping("/Create")
    public ResponseEntity<CategoryDTO> createcategory(@Valid  @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO CreateCategory = this.categoryService.createCategory(categoryDTO);
        return new ResponseEntity<CategoryDTO>(categoryDTO, HttpStatus.CREATED);

    }

    //Update
    @PutMapping("/{catId}")
    public ResponseEntity<CategoryDTO> updatecategorey(@RequestBody CategoryDTO categoryDTO, @PathVariable Integer catId) {


        CategoryDTO updatecategory = categoryService.updateCategory(categoryDTO, catId);
        return new ResponseEntity<CategoryDTO>(updatecategory, HttpStatus.CREATED);
    }
    //Delete

    @DeleteMapping("/{catId}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Integer CategoryId) {
        categoryService.delete(CategoryId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Category Delete Success ", true), HttpStatus.OK);
    }
    //Get

    @GetMapping("/{CategoryId}")
    public ResponseEntity<CategoryDTO> getcategory(@PathVariable Integer CategoryId) {
        CategoryDTO categoryDTO = categoryService.getCategory(CategoryId);
        return new ResponseEntity<CategoryDTO>(categoryDTO, HttpStatus.OK);
    }

    //GetAll
    @GetMapping("/")
    public ResponseEntity<List<CategoryDTO>> getAlllcategory() {

        List<CategoryDTO> categories = this.categoryService.getAllCategory();
        return ResponseEntity.ok(categories);
    }

}

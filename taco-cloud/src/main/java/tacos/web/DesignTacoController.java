package tacos.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;

import lombok.extern.slf4j.Slf4j;
import tacos.Taco;
import tacos.data.IngredientRepository;
import tacos.data.TacoRepository;
import tacos.Ingredient;
import tacos.Ingredient.Type;
import tacos.Order;

import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {
  @Autowired
  private final IngredientRepository ingredientRepo;

  @Autowired
  private TacoRepository designRepo;

  @ModelAttribute(name = "order")
  public Order order() {
	return new Order();
  }

  @ModelAttribute(name = "taco")
  public Taco taco() {
	return new Taco();
  }

  @Autowired
  public DesignTacoController(IngredientRepository ingredientRepo, TacoRepository designRepo) {
	this.ingredientRepo = ingredientRepo;
	this.designRepo = designRepo;
  }

  @GetMapping
  public String showDesignForm(Model model) {

	/*
	 * Type[] types = Ingredient.Type.values();
	 * 
	 * for (Type type : types) { model.addAttribute(type.toString().toLowerCase(),
	 * filterByType(ingredients, type)); }
	 */ //model.addAttribute("ingredients", ingredients);
	Taco taco = new Taco();
	List<Ingredient> ingredients = new ArrayList<>();
	ingredientRepo.findAll().forEach(i -> ingredients.add(i));
	taco.setIngredients(ingredients);

	model.addAttribute("taco", taco);
	return "design";
  }

  @PostMapping
  public String processDesign(@Valid @ModelAttribute Taco design, Errors errors, @ModelAttribute Order order) {
	if (errors.hasErrors()) {
	  return "design";
	}
	design.setCreatedAt(new Date());
	Taco saved = designRepo.save(design);
	order.addDesign(saved);
	return "redirect:/orders/current";
  }

  private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
	return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
  }
}

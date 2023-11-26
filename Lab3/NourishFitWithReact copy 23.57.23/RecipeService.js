import Recipe from './Recipe';

let recipes = [];

const recipeService = {
  getAllRecipes() {
    return recipes;
  },

  getRecipeById(id) {
    return recipes.find(recipe => recipe.id === id);
  },

  addRecipe(newRecipe) {
    recipes.push(newRecipe);
  },

  updateRecipe(id, updatedRecipe) {
    const index = recipes.findIndex(recipe => recipe.id === id);
    if (index !== -1) {
      recipes[index] = updatedRecipe;
    }
  },

  deleteRecipe(id) {
    recipes = recipes.filter(recipe => recipe.id !== id);
  },
};

export default recipeService;

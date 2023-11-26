import React, {useContext, useState} from 'react';
import {View, Text, Button, TextInput} from 'react-native';
import {RecipeContext} from 'RecipeContext';

const RecipeList = () => {
  const {recipes, addRecipe, updateRecipe, deleteRecipe} =
    useContext(RecipeContext);
  const [newRecipeTitle, setNewRecipeTitle] = useState('');
  const [editRecipeId, setEditRecipeId] = useState(null);
  const [editRecipeTitle, setEditRecipeTitle] = useState('');
  const [selectedRecipe, setSelectedRecipe] = useState(null);

  const handleAdd = () => {
    if (newRecipeTitle) {
      addRecipe({id: Date.now(), title: newRecipeTitle});
      setNewRecipeTitle('');
    }
  };

  const handleUpdate = () => {
    if (editRecipeId !== null && editRecipeTitle) {
      updateRecipe(editRecipeId, {id: editRecipeId, title: editRecipeTitle});
      setEditRecipeId(null);
      setEditRecipeTitle('');
    }
  };

  const handleDelete = id => {
    deleteRecipe(id);
    // No need to refresh the entire list; handle the removal locally
  };

  const handleEdit = recipe => {
    setEditRecipeId(recipe.id);
    setEditRecipeTitle(recipe.title);
  };

  const handleSelect = recipe => {
    setSelectedRecipe(recipe);
  };

  const renderRecipe = recipe => (
    <View key={recipe.id} style={{marginBottom: 10}}>
      <Text>Title: {recipe.title}</Text>
      <Button title="Edit" onPress={() => handleEdit(recipe)} />
      <Button title="Delete" onPress={() => handleDelete(recipe.id)} />
      <Button title="View Details" onPress={() => handleSelect(recipe)} />
    </View>
  );

  return (
    <View>
      <View style={{flexDirection: 'row', alignItems: 'center'}}>
        <TextInput
          style={{flex: 1, borderWidth: 1, padding: 8}}
          placeholder="Enter recipe title"
          value={newRecipeTitle}
          onChangeText={text => setNewRecipeTitle(text)}
        />
        <Button title="Add" onPress={handleAdd} />
      </View>

      {recipes.map(recipe => {
        if (recipe.id === editRecipeId) {
          return (
            <View
              key={recipe.id}
              style={{flexDirection: 'row', alignItems: 'center'}}>
              <TextInput
                style={{flex: 1, borderWidth: 1, padding: 8}}
                value={editRecipeTitle}
                onChangeText={text => setEditRecipeTitle(text)}
              />
              <Button title="Update" onPress={handleUpdate} />
            </View>
          );
        }
        return renderRecipe(recipe);
      })}

      {selectedRecipe && (
        <View style={{marginTop: 20}}>
          <Text>Selected Recipe Details:</Text>
          <Text>Title: {selectedRecipe.title}</Text>
          {/* Display other recipe details */}
          <Button
            title="Close Details"
            onPress={() => setSelectedRecipe(null)}
          />
        </View>
      )}
    </View>
  );
};

export default RecipeList;

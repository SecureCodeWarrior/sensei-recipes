# Sensei Recipes
Main repository for Sensei Recipes.

The 'recipes' folder is picked up by the Sensei-Hub for publication in production. This means we need to ensure that these recipes are fully compatible with the latest released version of Sensei.

When working on recipes, please create a branch to work on and only merge the branch after testing the recipes on an IntelliJ instance that is not running the alpha build of the plugin (or create a pull request).

## Recipe Pool Structure
The recipes pool is structured as follows:
- Level 1: Language
- Level 2: Category or framework (for multipurpose frameworks)
- Deeper levels per topic or framework

## Example code
To use the example code efficiently, load the root of this repository as an IntelliJ project. This way, the projects in example code will be loaded as modules.

See also the [Spring recipe examples repo](https://github.com/SecureCodeWarrior/spring-recipes-examples).

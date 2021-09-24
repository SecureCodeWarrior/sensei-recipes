# Sensei Recipes
This is the main repository for Sensei Recipes.

The 'recipes' folder is picked up by the Sensei Hub for publication in production. Once your cookbooks are picked up by the Hub, they will be published here: https://sensei.securecodewarrior.com. This means we need to ensure that these recipes are fully compatible with the latest released version of Sensei.

When working on recipes, please create a branch to work on and only merge the branch after testing the recipes on an IntelliJ instance that is not running the alpha build of the plugin (or create a pull request).

The Sensei Hub is scheduled to update its cookbooks twice a day at 6 AM and 3 PM GMT, as configured [here](https://github.com/SecureCodeWarrior/sensei-hub/blob/e5cc68f5999153a7cb099c50a7f902356f37e63a/source/src/main/java/scw/sensei/hub/cookbook/application/UpdateCookbookJob.java).

The 'drafts', 'broken' and 'opinionated' folders of this repository are legacy folders that will be replaced with branches in the future. Please do not add to these folders. Instead, add branches for draft recipes that can be merged once they become production ready.

## Recipe Pool Structure
The recipes pool is structured as follows:
- Level 1: Language
- Level 2: Category or framework (for multipurpose frameworks)
- Deeper levels per topic or framework

## Example code
In order to test the recipes we are creating, some example code projects are available in the "example_code" folder. In the long term this folder should be phased out in favour of separate repositories. An example of a separate project used for testing recipes is the [Spring recipe examples repository](https://github.com/SecureCodeWarrior/spring-recipes-examples).

## How to get started writing recipes
The main documentation (https://docs.sensei.securecodewarrior.com) provides a wealth of information and a great tutorial that walks you through the stages of writing a recipe, including the thought process. That's where you should start. It also provides detailed descriptions of the syntax, all the search targets and their configuration options.

Also be sure to check the "Syntax Reference > Templating" page to learn about some useful functionalities for quick fixes. 

## FAQ

### Why are my recipes not showing up on the Hub?
The Hub scans the "recipes" folder for recipes. In doing so it will ignore any recipes that are set to be disabled (so having the enabled checkbox unchecked).

If your recipe is enabled, present in the "recipes" folder and on the main branch of this repository, it should appear on the Hub after the next update (see scheduling information above).

### How do I create a new cookbook on the Hub?
Cookbooks require a bit of metadata to be displayed correctly on the Hub and in the Sensei plugin. This information is kept in the "cookbook-configuration.yaml". Adding a cookbook is as simple as adding an entry in that configuration.

To determine which recipes end up in your cookbook, you can provide tags that can be either included or excluded from the recipe pool. By default, the cookbook is empty. You need to include at least one tag to include any recipes in the cookbook.

### Which tags should I use?
As mentioned in the previous question, the tags are used to collect recipes into cookbooks. The best way to get an overview of the existing tags is to visit [the recipes page on the Hub](https://sensei.securecodewarrior.com/recipes) and look at the "Tags" filters.

The conventions used are as follows:
- Proper names (e.g. brands, names, technologies,...) are capitalised;
- Abbreviations in uppercase (e.g. SLF4J, CSRF,...);
- Other more generic terms in lowercase (e.g. categories).

In the future some axes will be defined to indicate how the tags relate to each other (e.g. security vs quality) so that they can be displayed in a more structured way on the Hub.

If a tag is missing, new ones can be created by using them in a recipe.

### What do I search for in a recipe?
First consider what part of the code you want to highlight and manipulate when writing a quick fix. The root element you are searching for impacts which quick fix actions are available.

To know which actions are available, visit the [actions topic in the documentation](https://docs.sensei.securecodewarrior.com/ref/actions.html#).

### It looks like I can't create my recipe... What now?
From time to time you'll want to do things in recipes that Sensei is not capable of yet. In that case you might want to request a new feature to be created. However, before you do, please ask whether there is a workaround or other feature that does the job by posting a message on the #sensei and #sensei-recipe-creation-crew Slack channels.

Once it is clear that the feature is missing, create a ticket on the Sensei Jira.

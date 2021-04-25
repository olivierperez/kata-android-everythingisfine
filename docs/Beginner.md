# Where do I start as an Beginner?

As a beginner in Android development I can give you some help to start.

## Unused code

Some code might be unused, it is distracting, and it doesn't need to stay.

## Inconsistency

### In classes

Two classes of the domain do the opposite, but their names doesn't follow the same style, it
may help a bit the readability to name them the same way but with opposite meaning.

### In layouts

Look at the IDs used in each layouts, what's wrong?

## Wrong navigation

1. Launch the app
2. Click on the first pokemon
3. Rotate the screen
4. Did you noticed something?

If not, go to Search screen and repeat the same steps, you should notice it doesn't follow the same
navigation.

## Resources

Usually in Android development we put displayed texts in `strings.xml`, but some layouts may use
hard coded texts. That's bad!

## Architecture

The `Pokemon` class is defined in the `data` layer but is also used in `domain` AND `presentation`.
The issue here is we can't add fields to it (because it needs to match the JSON format) but we would
like to add a `isInPokedex` at the `domain` layer in order to show a different pokeball if the
pokemon is in pokedex on not.

## Bug

On top of all the mistakes I've made, I failed to fulfil the requirements.

1. Go on Search screen
2. Search for "mew"
3. Click on the pokeball the say "I know the pokemon"
4. **FAIL!** The click should not navigate to the details screen

## More

When you have done fixing all of these mistakes, you should probably be ready for
[Intermediate hints](Intermediate.md).

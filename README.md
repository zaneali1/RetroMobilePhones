# Retro Mobile Phones
## Overview
Before the advent of smartphones, mobile telephones in English-speaking countries used keypads with buttons similar to below:

<p align="center">
<img src="https://github.com/zaneali1/RetroMobilePhones/blob/main/images/Keypad.jpg" width="160"/>
</p>

The keys are used for *both* calling numbers and texting messages; each key from 2-9 has a corresponding set of letters which 
can be used to input text. As keys are progressively input, a  predictive entry feature is used to display the closest match for the word.
This predictive text feature is known as the T9 (Text on 9 Keys) algorithm. 

Example:
| Input | Example Matches |
| --- | --- |
| 463 | inf, god |
| 4663 | good, gone, home, goof, hoof |
  

Special keys include '\*' which cycles through the possible matches for the current word, the'0' character which accepts 
the match for the word and adds a space and 'C' which removes the last entered character (or entire word if the word has been
'accepted').

The program creates a GUI which implements the T9 algorithm with a predictive feature. 

## Engineering Philosophies/Patterns Implemented
- Model-View Seperation
Features such as predictive text, typing and deleting characters are contained in Model classes such as *DictionaryModel* and 
*MapDictionary*, while the GUI is built in a seperate View class. This Model-View seperation provides a functionality that is
totally independent of the user interface

- The Observer Pattern
The view is set to be an observer which is notified by any state changes in the model. This pattern is demostrated in the program where 
two 'views' are created; when a change happens to one view, the other is updated accordingly.  

## Scope for Improvement
- Additional graphical features such as a drop-down menu with the list of possible matches for each word.
- An option to take numerical inputs directly from the keyboard (instead of clicking them on screen). 
- An option to add words to the dictionary (i.e. a dynamic dictionary). 

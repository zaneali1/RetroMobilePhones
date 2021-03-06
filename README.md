# Retro Mobile Phones
## Overview
Before the advent of smartphones, mobile telephones in English-speaking countries used keypads with buttons similar to below:

<p align="center">
<img src="https://github.com/zaneali1/RetroMobilePhones/blob/main/images/Keypad.jpg" width="160"/>
</p>

The keys are used for *both* calling numbers and texting messages; each key from 2-9 has a corresponding set of letters which 
can be used to input text. As keys are progressively input, a  predictive entry feature is used to display the closest match for the word.
This predictive text feature is known as the T9 (Text on 9 Keys) algorithm. 

| Input | Example Matches |
| --- | --- |
| 463 | inf, god |
| 4663 | good, gone, home, goof, hoof |
  

Special keys include '\*' which cycles through the possible matches for the current word, '0' which accepts 
the match for the word and adds a space and 'C' which removes the last entered character (or entire word if the word has been
'accepted'). This program creates a GUI which implements the T9 algorithm with a predictive feature. 

## Engineering Principles Implemented
- **Model-View Seperation:** Features such as predictive text and character deletion are contained in Model classes such as *DictionaryModel* and 
*MapDictionary*, while the GUI is built in a seperate *View* class. This supports separate development of the model and user interface layers and allows easy
porting of the model layer to another user interface framework. As an extension to the project, the interface can be changed to an image of a phone keypad 
which is possible from the Model-View seperation. 

- **The Observer Pattern:** The view is set to be an observer which is notified by any state changes in the model. This pattern is demostrated in the program where 
two 'views' are created; when a change happens to one view, the other is updated accordingly. (NB: Since this project was completed the Observer class in Java has
deprecated).

## Extension Activities
- Additional graphical features such as a drop-down menu with the list of possible matches for each word.
- An option to take numerical inputs directly from the keyboard (instead of clicking them on screen). 
- An option to add words to the dictionary (i.e. a dynamic dictionary). 

## The Hunt for Broken Arrow

### Introduction
[The Hunt for Broken Arrow](https://bendoschgit.github.io/scavenger_hunt_and_trivia/) was designed for The Museum Broken Arrow to be used in place of worksheets that they currently provide to guests. This application is currently designed for use on Android devices. Users are able to answer questions about exhibits at the museum through a free form text box, and Administrators are able to update, remove, and add questions through the administrative panel. 

[Read More](https://blanketmanatee.medium.com/the-hunt-for-broken-arrow-f4dbbd22b00b) about the project here.

This application was built by:
* [Ashley Price](https://www.linkedin.com/in/ashleybordenprice/) Front End Development
* [Ben Dosch](https://www.linkedin.com/in/benjamin-dosch-872a4731/) Full Stack Developer
* [Selidex Parnell](https://www.linkedin.com/in/selidex-parnell-6469a613b/) Research & Development
* [Ryan Devlin](https://www.linkedin.com/in/ryan-devlin-1151b81a9/) Back End Development
### Installation

### Usage
![Trivia Page](/images/trivia.png)
Users can enter answers to questions by clicking the answer button, and then typing in their answer. This data will be saved locally to app specific files to record each users answers. Local storage is currently in the process of being implemented, answer data is saved but does not appear in the trivia.

![Admin](/images/adminlogin.png)
For security purposes, the admin features are placed behind a password. When the correct password is entered, the user is then able to access the admin panel.

![Admin](/images/wrongpw.png)
If the incorrect password is entered, the user will need to re-enter the password to gain access.

![Admin](/images/admin2.png)
In later versions, the application will also have a scavenger hunt. On this screen, users will be able to select either the Trivia or Scavenger Hunt to modify.

![Edit Trivia](/images/edittrivia.png)
Here the user is able to add, delete, or modify trivia questions. Changes made update in real time for all devices currently using the application.

### Contributing

### Related Projects

### Licensing

### Not Yet Implemented

#### Storage
Local storage for individual users needs to be configured to populate the recycler views & get updated versions of questions from Firebase Realtime Database. Firebase Storage needs to be set up to send and recieve pictures to add to the scavenger hunt. An admin interface for uploading local photos to the Firebase Storage for new scavenger hunt questions needs to be built.

#### Question Types
Multiple choice questions with an indication of the correct answer are planed to be implemented in future releases. The option to make multiple choice questions where a photo from a selection is selected is an option we hope to explore. Trivia questions to be sorted by category (and the category displayed).

#### Functionality
A button to clear out all user answers, to facilitate the reuse of the device by museum patrons. Converting the buttons on the main activity page into a menu bar. Improve the formating and presentation of the scavengerhunt and associated pictures. Adding the use of the camera so users can take pictures of scavenger hunt items to mark that they have found them.

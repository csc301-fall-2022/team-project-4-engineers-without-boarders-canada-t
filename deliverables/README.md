## Description:
This is an android mobile application that develops for Engineers Without Borders Canada. This application is for people who are in areas lacking water or lack knowledge about water environment protection, it contains some questions about water purifying and a water filter experiment. The user will be required to finish these questions and build a virtual water filter. Then, the user will get a score to evaluate the performance of the water filter they create. The final goal of this application is to help people raise their awareness of water protection and learn some knowledge about water purifying.




## Key Features
- the introduction page of _the Engineers Without Boarders_ and _the Water For The World_(W4TW) workshop, it will give the users(mostly students) on some imformation of current world water situation and some stats.
- some multiple question pages to let the user choose the answer(not for mark, only for introduction and stats collection), the answers will be stored for later use, as well as a pre- and post-activity assessments to assess users’ knowledge or misconceptions on poverty, literacy and accessibility issues.
- the app will have a IP-based geolocation capability, such that it can provide imformation including: Country population, Gross Domestic Product (GDP) and Literacy Rate, according to location, as a reference to users.
- Virtual water filter building exercise which highlights the differences in accessing clean water in various locations in the world. This feature will be displayed as an interactive drag-and-drop system to enable filter building and experimentation, as well as utilize probability since outcomes should not be guaranteed from playthrough to playthrough. Also it will contains a shop page to let the user buy the materials they need for their water filter.
- Ability to share results of the differing filter building experiences between users to highlight the issues around accessing clean water. Also, when users(students) is firstly using the software, they will be asked to provide their teachers'/parents' email addresses, such that teachers or others who may wish to view the results of multiple users.



## Development requirements
- There's no requirement regarding OS. As long as Android Studio is installed, a developer can clone our codes and build the project locally.
- If you want to run the actual application, you need to go to "Build" > "Build Bundle(s) / APK (s)" > "Build APK(s)". After an APK is built, you could install the application to any Android machine.



## Instructions
On an Android smartphone, the user can install our application using an APK package. Download the APK package from our repository.
Following installation, the user can begin a new workshop session, and from there, instructions will be provided to walk them through the app's workflow.

The program opens to a page with two options: create new session or resume current session. You can only select the create new session option when using the app for the first time and if you quit while a workshop session was in progress. You can pick up where you left off by selecting "Resume Session."
In every page, there will be a back and next button for navigating between pages. 
Genrally, we have 4 types of pages,

The text information page has the following logic:
At the bottom of the page, there will be a checkbox to confirm you have read the text above.  You will only be able to navigate to the next page after checking the checkbox.

The multiple choice page has the following logic:
There will be options on the screen, and you can choose any of them, but the next page button only becomes available after you selected the right answer.

The logic behind the sliding scale page is as follows:
A question with a sliding bar asking the user to select the right response will be presented. The next page button will become available as soon as the user slides to the correct portion, at which point a text explanation describing why this is the correct area will be presented.

The final type of page is one used to construct a water filer. There will be 7 spaces on this page where the user can select the material to use for this layer. When a user clicks on an empty layer, they are taken to a page showing all the available items. After selecting an item, they are taken back to the page for creating the water filter, where the view has been modified to reflect the new additions. The page also display the amount of money the user have and the country the user representing. There will also be a store button, instruction button, and a evaluate button.

The store button to purchase the item needed to assemble the water filter, the user can navigate to a store.
The user's available money will be shown on the store page, along with a variety of items. Each item will have an add/minus button so that the user may choose the quantity they want to buy.
After choosing the things to purchase and completing the payment process, the app will return to water filter building page. When we click on a layer in the water filter, we can see the newly purchased items are now available for use. Additionally, the amount of money will also be updated.

Insturction button will navigate to a page displaying a guide about how to build the water filter.(i.e. what material to use in which order)
The evaluate button will give the user a score on the water filter they have built.

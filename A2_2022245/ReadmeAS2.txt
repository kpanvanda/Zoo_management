Commands to run :
mvn clean

mvn compile

mvn package

cd C:\Users\LENOVO\A2_2022245\target\classes
(navigate to .class files directory)

jar cfm C:\Users\LENOVO\A2_2022245\A2_2022245-1.0-SNAPSHOT.jar META-INF\MANIFEST.MF .
(this is the location of manifest.mf file)

NOTE: do not consider the jarfile generated in target folder consider the file in the A2_2022245 folder.




In the assignment to create a Portal for Zoo. 
I have initially asked if the user wants to enter as a visitor or an admin and incase of login as admin there is a login only in the case that the username= admin and password = admin123
I have satisfied this condition as it was given that we can take the input to be a constant.
In case the user logs in as a visitor then first they need to registen only then they can login to the visitor's menu.

There are certain assumptions that I have taken:

1. WHILE TAKING ANY INPUT USE "-" FOR REPLACING SPACE
2. By default the visitor is a basic member.
3. If the user chooses to read about the animal the I have printed a default text along with the sound of the animal made.
4. for taking the sound of the animal the user needs to enter both name and type of the animal.


The code assumes valid user input and does not include extensive input validation. Additional validation logic can be added for a production-ready system.
The program utilizes while loops to maintain the user interface, allowing users to navigate through different options until they choose to exit.

If the user chooses to login as an admin then they have various features that they have access to modify and if they chooses to login as a visitor they can view all the choices available to them and make an informed decision :

ATTRACTIONS , ANIMALS , FEEDBACK , EXPLORING ZOO , SPECIAL DEALS , DISCOUNTS:

--- the admin can add, modify and remove attractions,etc and visitor can visit any of these attractions,etc and all of these functions are performed by the use of a hashmap or an arraylist that helps to store all the data and print them when needed.


BUYING TICKETS , MEMBERSHIPS , ETC:

--- the visitor can buy tickets of specific functions or membership overall according to their needs and the balance available to them and the predefined amount is then deducted from the balance of the visitor.

for the animals I have used the concept of intefaces and polymorphism as it was easier to transfer all the basic features of an animal to all the three subcategories of mammal , amphibian and a repltile and i have used all the functions of adding and removing an animal in all these three classes which have made the functioning of my code simpler.

in this way the entire code functions and performs all the functions 
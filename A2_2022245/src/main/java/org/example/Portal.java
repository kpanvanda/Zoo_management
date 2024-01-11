package org.example;

import java.util.*;

public class Portal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Zoo zoo = new Zoo();
        Visitor presentVisitor = null;
        //String visitorFeedback = null;

        final String admin_username = "admin";
        final String admin_password = "admin123";

        //All arraylist and hashmaps

        Map<String, Visitor> visitors = new HashMap<>();
        Map<Integer, Attraction> attractions = new HashMap<>();
        Map<Integer, Integer> specialDeals = new HashMap<>();
        List<String> feedbackList = new ArrayList<>();
        ArrayList<Integer> attractionPrices = new ArrayList<>();
        HashMap<String, String> animalSounds = new HashMap<>();


        MammalManage MammalManage = new MammalManage();
        AmphibianManage AmphibianManage = new AmphibianManage();
        ReptileManage ReptileManage = new ReptileManage();

        System.out.println("Welcome to ZOOtopia!");



        while (true) {
            System.out.println("1. Enter as Admin");
            System.out.println("2. Enter as a Visitor");
            System.out.println("3. View Special Deals");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


            if (choice == 1) {
                System.out.println("Enter Admin Username:");
                String inputName = scanner.next();  // Use the existing 'scanner'

                System.out.println("Enter Admin Password:");
                String inputPassword = scanner.next();


                if (inputName.equals(admin_username) && inputPassword.equals(admin_password)) {
                    System.out.println("Admin Menu:");
                    System.out.println("1. Manage Attractions");
                    System.out.println("2. Manage Animals");
                    System.out.println("3. Schedule Events");
                    System.out.println("4. Set Discounts");
                    System.out.println("5. Set Special Deal");
                    System.out.println("6. View Visitor Stats");
                    System.out.println("7. View Feedback");
                    System.out.println("8. Exit Admin Menu");

                    System.out.print("Enter your choice: ");
                    int adminChoice = scanner.nextInt();

                    // ATTRACTIONS

                    if (adminChoice == 1) {
                        while (true) {
                            System.out.println("Manage Attractions:");
                            System.out.println("1. Add Attraction");
                            System.out.println("2. View Attractions");
                            System.out.println("3. Modify Attraction");
                            System.out.println("4. Remove Attraction");
                            System.out.println("5. Exit");
                            System.out.print("Enter your choice: ");
                            int attractionMenu = scanner.nextInt();

                            if (attractionMenu == 1) {

                                // add attractions

                                System.out.println("Enter Attraction Name: ");
                                String name = scanner.next();
                                System.out.println("Enter Attraction describe: ");
                                String describe = scanner.next();

                                Attraction attraction = new Attraction(name, describe);

                                attractions.put(attraction.getAttractionId(), attraction);

                                System.out.println("Attraction added with ID: " + attraction.getAttractionId());

                                System.out.println("Enter Attraction Price: ");
                                int rs = scanner.nextInt();

                                attractionPrices.add(rs);
                            }

                            //
                            //

                            else if (attractionMenu == 2) {
                                System.out.println("List of Attractions:");
                                for (Attraction attraction : attractions.values()) {
                                    System.out.println("ID: " + attraction.getAttractionId() + ", Name: " + attraction.getName() +
                                            ", describe: " + attraction.getDescribe());
                                }
                            }

                            //
                            //

                            else if (attractionMenu == 3) {
                                // Modify Attraction logic
                                System.out.print("Enter Attraction ID to modify: ");
                                int attractionId = scanner.nextInt();

                                if (attractions.containsKey(attractionId)) {
                                    Attraction attraction = attractions.get(attractionId);
                                    System.out.println("Current Name: " + attraction.getName());
                                    System.out.print("Enter new Name: ");
                                    String newName = scanner.next();
                                    System.out.println("Current describe: " + attraction.getDescribe());
                                    System.out.print("Enter new describe: ");
                                    String newdescribe = scanner.next();

                                    // Update attraction details
                                    attraction.setName(newName);
                                    attraction.setDescribe(newdescribe);
                                    System.out.println("Attraction updated successfully.");
                                } else {
                                    System.out.println("Attraction with ID " + attractionId + " not found.");
                                }

                            }

                            //
                            //

                            else if (attractionMenu == 4) {
                                // Remove Attraction logic
                                System.out.print("Enter Attraction ID to remove: ");
                                int attractionId = scanner.nextInt();

                                if (attractions.containsKey(attractionId)) {
                                    Attraction removeAttraction = attractions.remove(attractionId);
                                    System.out.println("Attraction with ID " + attractionId + " (Name: " + removeAttraction.getName() +
                                            ") has been removed successfully.");
                                } else {
                                    System.out.println("Attraction with ID " + attractionId + " not found.");
                                }
                            }

                            //
                            //

                            else if (attractionMenu == 5) {
                                break;
                            } else {
                                System.out.println("Invalid choice. Please try again.");
                            }
                        }
                    }

                    // ANIMALS

                    else if (adminChoice == 2) {
                        // Manage Animals logic
                        while (true) {
                            System.out.println("Manage Animals:");
                            System.out.println("1. Add Animal");
                            System.out.println("2. Update Animal Details");
                            System.out.println("3. Remove Animal");
                            System.out.println("4. Exit");
                            System.out.print("Enter your choice: ");
                            int animalMenu = scanner.nextInt();

                            if (animalMenu == 1) {
                                System.out.println("Enter Animal Name: ");
                                String name = scanner.next();
                                System.out.println("Enter Animal Type (Mammal, Amphibian, or Reptile): ");
                                String type = scanner.next();
                                System.out.println("Enter Sound made by the Animal: ");
                                String sound = scanner.next();

                                // Check if the entered type is one of the three allowed types
                                if (type.equals("Mammal") || type.equals("Amphibian") || type.equals("Reptile")) {
                                    // Add the animal to the respective list
                                    if (type.equals("Mammal")) {
                                        MammalManage.addAnimal(name, type, sound);
                                    } else if (type.equals("Amphibian")) {
                                        AmphibianManage.addAnimal(name, type , sound);
                                    } else if (type.equals("Reptile")) {
                                        ReptileManage.addAnimal(name, type , sound);
                                    }
                                    System.out.println("Animal added to Zoo.");
                                    animalSounds.put(name + type, sound);
                                    //System.out.println(animalSounds.get(name+type));
                                } else {
                                    System.out.println("Invalid animal type. Please enter Mammal, Amphibian, or Reptile.");
                                }
                            } else if (animalMenu == 2) {
                                // Update Animal Details logic

                                System.out.println("Enter Animal Name to Update: ");
                                String nameUpdate = scanner.next();
                                System.out.println("Enter Animal Type (Mammal, Amphibian, or Reptile): ");
                                String typeUpdate = scanner.next();

                                System.out.println("Enter Updated Animal Name: ");
                                String updatedName = scanner.next();
                                System.out.println("Enter Updated Animal Type: ");
                                String updatedType = scanner.next();
                                System.out.println("Enter Updated Sound made by the Animal: ");
                                String updatedSound = scanner.next();

                                boolean updatedinfo = false;

                                if (typeUpdate.equals("Mammal")) {
                                    updatedinfo = MammalManage.updateAnimal(nameUpdate, typeUpdate, updatedName, updatedType, updatedSound);
                                } else if (typeUpdate.equals("Amphibian")) {
                                    updatedinfo = AmphibianManage.updateAnimal(nameUpdate, typeUpdate, updatedName, updatedType, updatedSound);
                                } else if (typeUpdate.equals("Reptile")) {
                                    updatedinfo = ReptileManage.updateAnimal(nameUpdate, typeUpdate, updatedName, updatedType, updatedSound);
                                }

                                if (updatedinfo) {
                                    System.out.println("Animal details updated successfully.");
                                    animalSounds.put(updatedName + updatedType, updatedSound);
                                } else {
                                    System.out.println("Animal not found or update failed.");
                                }

                            } else if (animalMenu == 3) {
                                // Remove Animal logic
                                System.out.println("Enter Animal Name to Remove: ");
                                String nameRemove = scanner.next();
                                System.out.println("Enter Animal Type (Mammal, Amphibian, or Reptile): ");
                                String typeRemove = scanner.next();

                                boolean removeinfo = false;

                                if (typeRemove.equals("Mammal")) {
                                    removeinfo = MammalManage.removeAnimal(nameRemove);
                                } else if (typeRemove.equals("Amphibian")) {
                                    removeinfo = AmphibianManage.removeAnimal(nameRemove);
                                } else if (typeRemove.equals("Reptile")) {
                                    removeinfo = ReptileManage.removeAnimal(nameRemove);
                                }

                                if (removeinfo) {
                                    System.out.println("Animal removed from Zoo.");
                                    animalSounds.remove(nameRemove + typeRemove);
                                } else {
                                    System.out.println("Animal not found or removal failed.");
                                }

                            } else if (animalMenu == 4) {
                                break;
                            } else {
                                System.out.println("Invalid choice. Please try again.");
                            }
                        }
                    } else if (adminChoice == 3) {
                        // Schedule Events logic
                        EventManage eventManager = new EventManage();

                        while (true) {
                            System.out.println("Schedule Events:");
                            System.out.println("1. Add Event");
                            System.out.println("2. View Events");
                            System.out.println("3. Modify Event");
                            System.out.println("4. Remove Event");
                            System.out.println("5. Manage Attraction Schedule");
                            System.out.println("6. Set Attraction Ticket Price");
                            System.out.println("7. Exit");
                            System.out.print("Enter your choice: ");
                            int eventMenu = scanner.nextInt();
                            if (eventMenu == 1) {
                                // Add Event logic (as previously explained)
                            } else if (eventMenu == 2) {
                                // View Events logic (as previously explained)
                            } else if (eventMenu == 3) {
                                // Modify Event logic (as previously explained)
                            } else if (eventMenu == 4) {
                                // Remove Event logic (as previously explained)
                            } else if (eventMenu == 5) {
                                // Manage Attraction Schedule
                                System.out.println("Enter Attraction ID to set schedule for:");
                                int attractionId = scanner.nextInt();
                                // Implement code to set the open and close times for the attraction
                                System.out.println("Enter the open time (HH:mm:ss):");
                                String openTime = scanner.next();
                                System.out.println("Enter the close time (HH:mm:ss):");
                                String closeTime = scanner.next();


//                                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
//                                try {
//                                    Date openTime = timeFormat.parse(openTimeStr);
//                                    Date closeTime = timeFormat.parse(closeTimeStr);
//
//                                    // attractions.get(attractionId).setSchedule(openTime, closeTime);
//                                    System.out.println("Attraction schedule set successfully.");
//                                } catch (ParseException e) {
//                                    System.out.println("Invalid time format. Please enter time in HH:mm:ss format.");
//                                }
                            } else if (eventMenu == 6) {
                                // Set Attraction Ticket Price
                                System.out.println("Enter Attraction ID to set the ticket price for:");
                                int attractionId = scanner.nextInt();
                                System.out.println("Enter the new ticket price:");
                                int newPrice = scanner.nextInt();
                                // Set the ticket price for the attraction
                                attractions.get(attractionId).setPrice(newPrice);
                                System.out.println("Attraction ticket price set successfully.");
                            } else if (eventMenu == 7) {
                                break;
                            } else {
                                System.out.println("Invalid choice. Please try again.");
                            }
                        }

                    }

                    // DISCOUNTS

                    else if (adminChoice == 4) {
                        // Set Discounts logic
                        while (true) {
                            System.out.println("Set Discounts:");
                            System.out.println("1. Add Discount");
                            System.out.println("2. Modify Discount");
                            System.out.println("3. Remove Discount");
                            System.out.println("4. Exit");
                            System.out.print("Enter your choice: ");
                            int discountMenu = scanner.nextInt();

                            if (discountMenu == 1) {

                                //add

                                System.out.print("Enter Discount discountName: ");
                                String discountName = scanner.next();
                                System.out.print("Enter Discount discountPercent (e.g., 20 for 20%): ");
                                int discountPercent = scanner.nextInt();


                                zoo.addDiscount(discountName, discountPercent);
                                System.out.println("Discount added successfully.");


                            } else if (discountMenu == 2) {

                                //modify


                                System.out.print("Enter the Discount discount category to modify: ");
                                String discountName = scanner.next();

                                if (zoo.getDiscounts().containsKey(discountName)) {
                                    System.out.print("Enter the new Discount discountPercent (e.g., 20 for 20%): ");
                                    int newdiscountPercent = scanner.nextInt();
                                    zoo.addDiscount(discountName, newdiscountPercent);
                                    System.out.println("Discount for " + discountName + " modified successfully.");
                                } else {
                                    System.out.println("Discount discount category not found.");
                                }


                            } else if (discountMenu == 3) {

                                //remove


                                System.out.print("Enter the Discount discount category to remove: ");
                                String discountName = scanner.next();

                                if (zoo.getDiscounts().containsKey(discountName)) {
                                    zoo.removeDiscount(discountName);
                                    System.out.println("Discount for " + discountName + " removed successfully.");
                                } else {
                                    System.out.println("Discount discountName not found.");
                                }
                            } else if (discountMenu == 4) {
                                // Exit the Set Discounts menu
                                break;
                            } else {
                                System.out.println("Invalid choice. Please try again.");
                            }
                        }
                    }

                    // SPECIAL DEALS

                    else if (adminChoice == 5) {
                        while (true) {
                            System.out.println("Set Special Deals:");
                            System.out.println("1. Add Special Deal");
                            System.out.println("2. Remove Special Deal");
                            System.out.println("3. Exit");
                            System.out.print("Enter your choice: ");
                            int specialMenu = scanner.nextInt();

                            if (specialMenu == 1) {

                                //add


                                System.out.print("Enter the minimum number of attractions for the deal: ");
                                int minimumAttraction = scanner.nextInt();
                                System.out.print("Enter the discount discountPercent for this deal (e.g., 15 for 15%): ");
                                int discountPercent = scanner.nextInt();
                                specialDeals.put(minimumAttraction, discountPercent);

                                // Map<Integer, Integer> specialDeals = new HashMap<>();
                                // specialDeals.put(minimumAttraction, discountPercent);


                                System.out.println("Special deal added successfully.");


                            } else if (specialMenu == 2) {

                                //remove


                                System.out.print("Enter the minimum number of attractions to remove the deal: ");
                                int minimumAttraction = scanner.nextInt();
                                specialDeals.remove(minimumAttraction);
                                // Implement the code to remove the special deal from your data structure

                                System.out.println("Special deal for " + minimumAttraction + " attractions removed.");


                            } else if (specialMenu == 3) {
                                break; // Exit the Set Special Deals menu
                            } else {
                                System.out.println("Invalid choice. Please try again.");
                            }
                        }
                    } else if (adminChoice == 6) {
                        // View Visitor Stats logic
                    }
                    else if (adminChoice == 7) {
                        // View Feedback logic
                        if (!feedbackList.isEmpty()) {
                            System.out.println("Visitor Feedback:");
                            for (String feedback : feedbackList) {
                                System.out.println(feedback);
                            }
                        } else {
                            System.out.println("No visitor feedback available.");
                        }

                    }

                    else if (adminChoice == 8) {
                        // Exit Admin Menu logic
                        continue;
                    }
                    else {
                        System.out.println("Invalid choice. Please try again.");
                    }
                }
                else {
                    System.out.println("Access denied. Incorrect username or password.");
                }

            }



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


            else if (choice == 2) {
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.print("Enter your choice: ");
                int visitorChoice = scanner.nextInt();

                if (visitorChoice == 1) {
                    System.out.println("Enter Visitor Name: ");
                    String name = scanner.next();

                    System.out.println("Enter Visitor Age: ");
                    int age = scanner.nextInt();

                    System.out.println("Enter Visitor Phone Number: ");
                    long contact = scanner.nextLong();

                    System.out.println("Enter Visitor Balance: ");
                    int balance = scanner.nextInt();

                    System.out.println("Enter Visitor Email: ");
                    String email = scanner.next();

                    System.out.println("Enter Visitor Password: ");
                    String password = scanner.next();

                    Visitor newVisitor = new Visitor(name, age, contact, balance, email, password);
                    visitors.put(email, newVisitor);
                    System.out.println("Registration is successful.");

                } else if (visitorChoice == 2) {
                    System.out.println("Enter Visitor Email: ");
                    String email = scanner.next();
                    System.out.println("Enter Visitor Password: ");
                    String password = scanner.next();

                    Visitor oldVisitor = visitors.get(email);
                    if (oldVisitor != null && oldVisitor.password.equals(password)) {
                        System.out.println("Login Successful.");
                        presentVisitor = oldVisitor;


                        while (true) {
                            System.out.println("Visitor Menu:");
                            System.out.println("1. Explore the Zoo");
                            System.out.println("2. Buy Membership");
                            System.out.println("3. Buy Tickets");
                            System.out.println("4. View Discounts");
                            System.out.println("5. View Special Deals");
                            System.out.println("6. Visit Animals");
                            System.out.println("7. Visit Attractions");
                            System.out.println("8. Leave Feedback");
                            System.out.println("9. Log Out");
                            System.out.print("Enter your choice: ");
                            int visitorMenu = scanner.nextInt();


                            // Implement visitor menu options here
                            if (visitorMenu == 1) {
                                // Explore the Zoo logic

                                System.out.println("Explore the Zoo:");
                                System.out.println("1. View Attractions");
                                System.out.println("2. View Animals");
                                System.out.println("3. Exit");
                                System.out.print("Enter your choice: ");
                                int exploreMenu = scanner.nextInt();

                                if (exploreMenu == 1) {
                                    // View Attractions
                                    System.out.println("Attractions in the Zoo:");
                                    int choicee = 1;
                                    for (Attraction attraction : attractions.values()) {
                                        System.out.println(choicee + ". " + attraction.getName());
                                        choicee++;
                                    }
                                    System.out.println(choicee + ". Exit");
                                    System.out.print("Enter your choice: ");
                                    int selectedChoice = scanner.nextInt();

                                    if (selectedChoice >= 1 && selectedChoice <= attractions.size()) {
                                        // Redirect to visitorMenu == 7 for visiting attractions
                                        visitorMenu = 7;
                                        System.out.println("ZOOtopia offers an adventure ride that allows you to explore unexplored trails. Buy your ticket now!\n");
                                        break; // Exit the loop
                                    } else if (selectedChoice == choice) {
                                        // Exit
                                        break; // Exit the loop
                                    } else {
                                        System.out.println("Invalid choice.");
                                    }

                                } else if (exploreMenu == 2) {
                                    // View Animals
                                    visitorMenu = 6;
                                    System.out.println("ZOOtopia offers an adventure ride that allows you to explore unexplored trails. Buy your ticket now!\n");
                                    break;

                                } else if (exploreMenu == 3) {
                                    // Exit
                                    break;

                                } else {
                                    System.out.println("Invalid choice. Please try again.");
                                }


                            } else if (visitorMenu == 2) {
                                // Buy Membership logic
                                System.out.println("Buy Membership:");
                                System.out.println("1. Basic Membership - Rs.20");
                                System.out.println("2. Premium Membership - Rs.50");

                                System.out.print("Enter your choice: ");
                                int membershipMenu = scanner.nextInt();

                                if (membershipMenu == 1) {
                                    if (presentVisitor.getBalance() >= 20) {
                                        presentVisitor.deductBalance(20); // Deduct the cost of Basic Membership
                                        presentVisitor.setMembership("Basic");
                                        System.out.println("Basic Membership purchased successfully. Your balance is now Rs." + presentVisitor.getBalance());
                                    } else {
                                        System.out.println("Insufficient balance to purchase Basic Membership.");
                                    }
                                } else if (membershipMenu == 2) {
                                    if (presentVisitor.getBalance() >= 50) {
                                        presentVisitor.deductBalance(50); // Deduct the cost of Premium Membership
                                        presentVisitor.setMembership("Premium");
                                        System.out.println("Premium Membership purchased successfully. Your balance is now Rs." + presentVisitor.getBalance());
                                    } else {
                                        System.out.println("Insufficient balance to purchase Premium Membership.");
                                    }
                                } else {
                                    System.out.println("Invalid choice for membership.");
                                }
                            } else if (visitorMenu == 3) {
                                // Buy Tickets logic
                                System.out.println("Buy Tickets:");
                                System.out.println("Select an Attraction to Buy a Ticket:");

                                // Display attractions and their prices
                                for (Map.Entry<Integer, Attraction> entry : attractions.entrySet()) {
                                    int attractionId = entry.getKey();
                                    Attraction attraction = entry.getValue();
                                    int price = attractionPrices.get(attractionId - 1); // Subtract 1 to get the correct index

                                    System.out.println(attractionId + ". " + attraction.getName() + " (₹" + price + ")");
                                }

                                System.out.print("Enter your choice: ");
                                int chosenId = scanner.nextInt();

                                if (attractions.containsKey(chosenId)) {
                                    Attraction selectedAttraction = attractions.get(chosenId);
                                    int price = attractionPrices.get(chosenId - 1); // Subtract 1 to get the correct index

                                    if (presentVisitor.getBalance() >= price) {
                                        // Subtract the ticket price from the visitor's balance
                                        presentVisitor.setBalance(presentVisitor.getBalance() - price);

                                        // Display a success message
                                        System.out.println("The ticket for " + selectedAttraction.getName() + " was purchased successfully. Your balance is now ₹" + presentVisitor.getBalance() + ".");
                                    } else {
                                        // Not enough balance
                                        System.out.println("Sorry, you don't have enough balance to purchase the ticket for " + selectedAttraction.getName() + ".");
                                    }
                                } else {
                                    // Invalid attraction choice
                                    System.out.println("Invalid attraction choice.");
                                }
                            } else if (visitorMenu == 4) {
                                // View Discounts logic
                                System.out.println("Available Discounts:");
                                Map<String, Integer> discounts = zoo.getDiscounts();

                                if (discounts.isEmpty()) {
                                    System.out.println("No discounts available at the moment.");
                                } else {
                                    for (Map.Entry<String, Integer> entry : discounts.entrySet()) {
                                        System.out.println(entry.getKey() + ": " + entry.getValue() + "%");
                                    }
                                }
                            } else if (visitorMenu == 5) {
                                // View Special Deals logic
                                if (specialDeals.isEmpty()) {
                                    System.out.println("No special deals available at the moment.");
                                } else {
                                    System.out.println("Special Deals:");
                                    for (Map.Entry<Integer, Integer> entry : specialDeals.entrySet()) {
                                        int minimumAttraction = entry.getKey();
                                        int discountPercent = entry.getValue();
                                        System.out.println("Minimum Attractions: " + minimumAttraction + ", Discount: " + discountPercent + "%");
                                    }
                                }
                            } else if (visitorMenu == 6) {
                                // Visit Animals logic
                                System.out.println("Choose an action:");
                                System.out.println("1. Feed the animal");
                                System.out.println("2. Read about the animal ");
                                System.out.print("Enter your choice: ");
                                int actionChoice = scanner.nextInt();

                                if (actionChoice == 1) {


                                    System.out.print("Enter the name of the animal: ");
                                    String animalName = scanner.next();

                                    System.out.print("Enter the type of the animal: ");
                                    String animalType = scanner.next();

//                                    System.out.println("Input animal name: " + animalName );

                                    String animalSound = animalSounds.get(animalName + animalType);

//                                    System.out.println("Retrieved animal sound: " + animalSound);

//                                    // Feed the animal
//                                    System.out.print("Enter the name of the animal: ");
//                                    String animalName = scanner.next();
//
//                                    // Check if the animal name exists in the animalSounds HashMap
//                                    String animalSound = animalSounds.get(animalName);
//                                    System.out.println(animalSound);

                                    if (animalSound != null) {
                                        System.out.println("You are feeding the " + animalName);
                                        System.out.println("The " + animalName + " makes the following sound: " + animalSound);
                                    } else {
                                        System.out.println("Animal not found in the zoo or no sound recorded.");
                                    }
                                } else if (actionChoice == 2) {
                                    // Read about the animal
                                    System.out.print("Enter the name of the animal: ");
                                    String animalName = scanner.next();

                                    System.out.print("Enter the type of the animal: ");
                                    String animalType = scanner.next();

                                    // Check if the animal name exists in the animalSounds HashMap
                                    String animalSound = animalSounds.get(animalName + animalType);

                                    if (animalSound != null) {
                                        System.out.println("About the " + animalName + ": " + animalSound);
                                    } else {
                                        System.out.println("Animal not found in the zoo or no information available.");
                                    }
                                } else {
                                    System.out.println("Invalid choice.");
                                }


                            } else if (visitorMenu == 7) {
                                // Visit Attractions logic
                                System.out.println("Visit Attractions:");
                                System.out.println("Select an Attraction to Visit:");

                                int choicee = 1;
                                for (Attraction attraction : attractions.values()) {
                                    System.out.println(choicee + ". " + attraction.getName());
                                    choicee++;
                                }

                                System.out.println(choicee + ". Exit");
                                System.out.print("Enter your choice: ");

                                int selectedChoice = scanner.nextInt();

                                if (selectedChoice >= 1 && selectedChoice <= attractions.size()) {
                                    Attraction selectedAttraction = attractions.get(selectedChoice);
                                    boolean Pmember = "Premium".equals(presentVisitor.getMembership());

                                    if (Pmember) {
                                        System.out.println("You are a Premium Member. Enjoy your visit to " + selectedAttraction.getName() + "!");
                                    } else {
                                        System.out.println("You are a Basic Member. Ticket not available. Basic Members need to buy separate tickets for the attractions.");
                                    }
                                } else if (selectedChoice == choicee) {
                                    // Exit
                                    System.out.println("Exiting Visit Attractions.");
                                } else {
                                    System.out.println("Invalid choice.");
                                }
                            } else if (visitorMenu == 8) {
                                // Leave Feedback logic
                                System.out.println("Leave Feedback:");
                                System.out.print("Enter your feedback: ");
                                String feedback = scanner.next();
                                feedbackList.add(feedback);
                                System.out.println("Feedback submitted successfully.");

                            } else if (visitorMenu == 9) {
                                // Log Out logic
                                break; // Break the loop to return to the main menu
                            }
                            else {
                                System.out.println("Invalid choice. Please try again.");
                            }
                        }
                    } else {
                        System.out.println("Invalid email or password. Please try again.");
                    }
                }

            }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


            else if (choice == 3) {
                // View special deals
                // Implement the special deals view here
                for (Map.Entry<Integer, Integer> entry : specialDeals.entrySet()) {
                    System.out.println("Attractions : " + entry.getKey() + ", discount : " + entry.getValue());
                }
            }
            else {
                System.out.println("Invalid choice. Please try again.");
            }

        }
    }
}


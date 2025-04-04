# COMP-2522-202510-Term-project-NinJava-Assassin

## Name:
Khai Phan

## Student number:
A01406264

## GitHub name:
khaiphan812

## Java version:
Java 23

## JavaFX version:
JavaFX 24

## Overview
NinJava Assassin is an arcade-style game developed using JavaFX 24, where players navigate a ninja (Genji)
through the scenic view of Mount Fuji and defend Princess Kiriko inside the Hanamura Temple
from attacks by the legion of Junkrats and Roadhogs.
The objective is to survive as long as possible and destroy enemies to prevent them from invading the Hanamura Temple.
The more enemy the player destroys, the higher score they achieve.

## Features
 * Difficulty: The game starts with an easy difficulty. As player score gets higher, difficulty level increases.
 * Junkrats: Regular enemies that spawn randomly and frequently, and their speed as the player score gets higher.
 * Roadhogs: Special bosses that spawn randomly and less frequently, their speed remain constant.
 * Shuriken: Weapon that the player uses to throw at the enemies and bosses to destroy them. 
It takes 1 shuriken to destroy a Junkrat and 5 shurikens to destroy a Roadhog.
 * Score: Each Junkrat kill is worth 10 points, while each Roadhog kill is worth 50 points. 
 * Lives: The starting life count is 10. The player loses one life everytime an enemy reaches the bottom of the map
or touches the player. The game is over when the player runs out of all lives.

## Prerequisites
To run this game, you'll need to have the following installed:
 * Java Development Kit (JDK) version 23.0.2 or higher
 * JavaFX SDK version 24 or higher

## Dependencies
 * JavaFX: Used for creating the graphical interface and animations.
 * JDK: The Java Development Kit is required for compiling and running the Java application.

## Installation and running the game
Recommended software to run the game: IntelliJ IDEA from JetBrains.
 * Step 1: Clone the repository
 * Step 2: Compile the source code
 * Step 3: Run the main method in NinJava class
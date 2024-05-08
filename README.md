Project Name: NMSU EZ PARKING 
Group Name: GitGud

Overview

Welcome to NMSU EZ PARKING! This repository contains the source code and resources for our project. Here, you'll find detailed instructions on how to browse and understand the project structure.

Project Structure

The project is structured as follows:

FXML Files: This directory contains all the FXML files used for defining the user interface layouts.
Controllers: The Controllers directory houses all the controller classes responsible for handling user interactions and application logic.
parking lot data: Here, you find all the available lots or unavailable lots significant to each parking lot. It shows that if a parking space is available, 0 will follow the neumber. If the parking lot is taken, it will show a 1 followed after the parking lot number.
Resources: Here, you'll find various resources used in the project, such as images, CSS files, and other assets.
Data Files: This directory includes any data files used by the application, such as text files for storing parking lot information.
Documentation: In this directory, you'll find additional documentation related to the project, including README files, user guides, and design documents.

How to Browse

To browse the project, follow these steps:

Start by exploring the FXML Files directory to understand the structure of the user interface layouts.
Next, navigate to the Controllers directory to examine the controller classes and understand how they handle user interactions and application logic.
Take a look at the Resources directory to view any images, CSS files, or other assets used in the project.
If applicable, check out the Data Files directory to see any data files used by the application, such as text files storing parking lot information.
Finally, review the Documentation directory for additional information, including README files providing context about specific components or features of the project.

Getting Started

Running the GUI on your system: 

Begin by downloading the JavaFX Software Development Kit (SDK), typically identified as javafx-sdk-22.

Within your Visual Studio Code (VSCode) environment, navigate to the bottom-left corner of the window, where you'll find the "JAVA PROJECTS" section. Beneath this, locate the sidebar titled "Referenced Libraries." Click on the plus sign and proceed to add all the Jar files contained within your javafx-sdk-22 folder. These Jar files are typically situated within the lib directory. It's imperative to include all Jar files to ensure comprehensive library integration.Should any difficulties arise during this process, refer to the settings.json file for guidance. An illustrative example is provided below:

{
    "java.project.sourcePaths": ["src"],
    "java.project.outputPath": "bin",
    "java.project.referencedLibraries": [
        "lib/**/*.jar",

        "/Users/paulinerosales/Desktop/javafx-sdk-22/lib/**/*.jar"
    ]
}

You may find it necessary to insert the pathway under referencedLibraries in both the settings.json file within the NMSUEZPARKING project directory and externally, within the repository. Occasionally, VSCode may relocate the .vscode folder outside the project directory for reasons unknown.

Navigate to the .vscode directory and locate the launch.json file. Within this file, introduce the "VmArgs" attribute and meticulously replicate the syntax provided below:

For Linux and macOS systems:

"vmArgs": "--module-path /path/to/javafx-sdk-22/lib --add-modules javafx.controls,javafx.fxml"

For Windows systems:

"vmArgs": "--module-path "/path/to/javafx-sdk-22/lib" --add-modules javafx.controls,javafx.fxml"

Replace the placeholder "/path/to/javafx-sdk-22/lib" with the actual pathway leading to your javafx-sdk-22/lib directory. It is paramount to substitute this placeholder with your specific directory path to ensure accurate module pathing.


To get started with the project, follow these steps:


Clone the repository to your local machine using git clone .
Open the project in your preferred Integrated Development Environment (IDE) or text editor.
Review the README files and documentation to understand the project structure, features, and how to run the application.
Explore the source code and resources to familiarize yourself with the project's implementation.
In order to run the GUI window you must run it from Main.java

If you encounter any issues or have questions, refer to the documentation or reach out to the project contributors for assistance.



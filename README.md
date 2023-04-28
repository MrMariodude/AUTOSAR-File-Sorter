# AUTOSAR File Sorter

This program sorts the containers in an AUTOSAR XML file in alphabetical order by their short name. The sorted containers are then written to a new XML file with "_mod" appended to the original file name.


## Getting Started

### Prerequisites
To run the AUTOSAR File Sorter, you need to have the following software installed:

Java Development Kit (JDK) 8 or higher

## Installation

1-Clone the repository or download the source code.

2-Navigate to the project directory in a terminal or command prompt.

3-Compile the source code by running the following command:

                                javac Project.java

## Usage

To use the AUTOSAR File Sorter, follow these steps:

1-Open a terminal or command prompt and navigate to the project directory.

2-Run the program by specifying the path to the input AUTOSAR XML file as a command-line argument. For example:

                        java Project path/to/input/file.arxml
If the input file is not a valid AUTOSAR XML file or is empty, the program will throw an exception.

3-The sorted containers will be written to a new XML file with "_mod" appended to the original file name. For example, if the input file is "input_file.arxml", the output file will be "input_file_mod.arxml".

## Contributing

If you would like to contribute to the AUTOSAR File Sorter, please follow these guidelines:

1-Fork the repository.

2-Create a new branch for your changes.

3-Make your changes and commit them.

4-Push your changes to your fork.

5-Submit a pull request to the main repository.

